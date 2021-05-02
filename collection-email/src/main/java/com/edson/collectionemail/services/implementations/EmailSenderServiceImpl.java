package com.edson.collectionemail.services.implementations;

import static com.edson.collectionemail.controllers.dtos.EmailSenderDTO.MAIL_SUBJECT;
import static com.edson.collectionemail.controllers.dtos.EmailSenderDTO.SENDER;

import com.edson.collectionemail.controllers.dtos.EmailDTO;
import com.edson.collectionemail.controllers.dtos.EmailResultDTO;
import com.edson.collectionemail.controllers.dtos.EmailSenderDTO;
import com.edson.collectionemail.dataproviders.models.Email;
import com.edson.collectionemail.dataproviders.models.EmailConfirmation;
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
  private PrepareBodyMailUseCase prepareBodyMailUseCase;

  @Autowired
  private JavaMailSender javaMailSender;

  public EmailResultDTO sendEmailToCustomer(EmailSenderDTO emailSenderDTO, EmailDTO emailDTO) {
    try {
      final var mailMessage = new SimpleMailMessage();

      mailMessage.setFrom(SENDER);
      mailMessage.setTo(emailDTO.getEmailCustomer());
      mailMessage.setSubject(MAIL_SUBJECT);
      mailMessage.setText(prepareBodyMailUseCase
          .prepareBodyMessage(emailDTO.getDocumentCustomer()));

      javaMailSender.send(mailMessage);

      final var emailConfirmation = new EmailConfirmation();
      emailConfirmation.setEmail(Email.convertFromDTO(emailDTO));
      emailConfirmation.setWasSent(Boolean.TRUE);

      return EmailResultDTO.of(Boolean.TRUE, "Success sent");
    } catch (RuntimeException e) {
      final var emailConfirmation = new EmailConfirmation();
      emailConfirmation.setEmail(Email.convertFromDTO(emailDTO));
      emailConfirmation.setWasSent(Boolean.FALSE);

      return EmailResultDTO.of(Boolean.FALSE, e.getMessage());
    }
  }
}
