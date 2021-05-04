package com.edson.collectionemail.services.implementations;

import static com.edson.collectionemail.controllers.dtos.EmailSenderDTO.MAIL_SUBJECT;
import static com.edson.collectionemail.controllers.dtos.EmailSenderDTO.SENDER;

import com.edson.collectionemail.controllers.dtos.CustomerResponseDTO;
import com.edson.collectionemail.controllers.dtos.EmailDTO;
import com.edson.collectionemail.controllers.dtos.EmailResultDTO;
import com.edson.collectionemail.controllers.dtos.EmailSenderDTO;
import com.edson.collectionemail.dataproviders.models.Email;
import com.edson.collectionemail.dataproviders.models.EmailConfirmation;
import com.edson.collectionemail.dataproviders.repositories.EmailConfirmationRepository;
import com.edson.collectionemail.services.CustomerService;
import com.edson.collectionemail.services.EmailSenderService;
import com.edson.collectionemail.usecase.implementations.PrepareBodyMailUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * EmailSenderServiceImpl
 *
 * @author : Edson Costa
 * @since : 02/05/2021
 **/
@Service
public class EmailSenderServiceImpl implements EmailSenderService {

  @Autowired
  private EmailConfirmationRepository emailConfirmationRepository;

  @Autowired
  private PrepareBodyMailUseCase prepareBodyMailUseCase;

  @Autowired
  private JavaMailSender javaMailSender;

  @Autowired
  private CustomerService customerService;

  public EmailResultDTO sendEmailToCustomer(EmailSenderDTO emailSenderDTO, EmailDTO emailDTO) {

    final CustomerResponseDTO customerByDocument = customerService
        .getCustomerByDocument(emailDTO.getDocumentCustomer());

    try {
      final SimpleMailMessage mailMessage = new SimpleMailMessage();

      mailMessage.setFrom(SENDER);
      mailMessage.setTo(emailDTO.getEmailCustomer());
      mailMessage.setSubject(MAIL_SUBJECT);
      mailMessage.setText(prepareBodyMailUseCase
          .prepareBodyMessage(customerByDocument.getDocument()));

      javaMailSender.send(mailMessage);

      final EmailConfirmation emailConfirmation = new EmailConfirmation();
      emailConfirmation.setEmail(Email.convertFromDTO(emailDTO));
      emailConfirmation.setWasSent(Boolean.TRUE);

      emailConfirmationRepository.save(emailConfirmation);

      return EmailResultDTO.of(Boolean.TRUE, "Success sent");
    } catch (RuntimeException e) {
      final EmailConfirmation emailConfirmation = new EmailConfirmation();
      emailConfirmation.setEmail(Email.convertFromDTO(emailDTO));
      emailConfirmation.setWasSent(Boolean.FALSE);

      emailConfirmationRepository.save(emailConfirmation);

      return EmailResultDTO.of(Boolean.FALSE, e.getMessage());
    }
  }
}
