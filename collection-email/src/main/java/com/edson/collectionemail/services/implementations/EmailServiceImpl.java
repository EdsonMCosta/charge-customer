package com.edson.collectionemail.services.implementations;

import com.edson.collectionemail.controllers.dtos.EmailDTO;
import com.edson.collectionemail.dataproviders.models.Email;
import com.edson.collectionemail.dataproviders.repositories.EmailRepository;
import com.edson.collectionemail.services.EmailService;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EmailServiceImpl
 *
 * @author : Edson Costa
 * @since : 02/05/2021
 **/
@Service
public class EmailServiceImpl implements EmailService {

  @Autowired
  private EmailRepository emailRepository;

  @Override
  public List<EmailDTO> findAll() {
    final var emails = emailRepository.findAll();

    return emails
        .stream()
        .map(EmailDTO::convertFromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public EmailDTO findByDocumentCustomer(String documentCustomer) {
    final var email = emailRepository
        .findByDocumentCustomer(documentCustomer)
        .orElseThrow(() -> new EmailNotFoundException("Email not found."));

    return EmailDTO.convertFromEntity(email);
  }

  @Override
  @Transactional(rollbackOn = Exception.class)
  public void saveEmail(EmailDTO emailDTO) {
    final var email = Email.convertFromDTO(emailDTO);

    emailRepository.save(email);
  }

  @Override
  @Transactional(rollbackOn = Exception.class)
  public void deleteEmail(Integer id) {
    final var byId = emailRepository.findById(id)
        .orElseThrow(() -> new EmailNotFoundException("Email not found."));

    emailRepository.delete(byId);
  }


  public static class EmailNotFoundException extends RuntimeException {

    public EmailNotFoundException(String message) {
      super(message);
    }
  }
}
