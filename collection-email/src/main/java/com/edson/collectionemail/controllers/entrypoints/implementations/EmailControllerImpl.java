package com.edson.collectionemail.controllers.entrypoints.implementations;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.edson.collectionemail.controllers.dtos.CollectionEmailDTO;
import com.edson.collectionemail.controllers.dtos.EmailDTO;
import com.edson.collectionemail.controllers.entrypoints.EmailController;
import com.edson.collectionemail.services.EmailService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmailControllerImpl
 *
 * @author : Edson Costa
 * @since : 02/05/2021
 **/
@RestController
@RequestMapping("/email")
public class EmailControllerImpl implements EmailController {

  @Autowired
  private EmailService emailService;

  @Override
  @GetMapping(value = "/list", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<EmailDTO>> getAllEmails() {
    final List<EmailDTO> all = emailService.findAll();
    return ResponseEntity
        .ok(all);
  }

  @Override
  @GetMapping(value = "/list/{document}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<EmailDTO> findByDocumentCustomer(@PathVariable String documentCustomer) {
    final EmailDTO byDocumentCustomer = emailService.findByDocumentCustomer(documentCustomer);

    return ResponseEntity
        .ok(byDocumentCustomer);
  }

  @Override
  @PostMapping(value = "/save", consumes = APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> createEmail(@RequestBody @Valid EmailDTO emailDTO) {
    emailService.saveEmail(emailDTO);
    final String emailCustomer = emailDTO.getEmailCustomer();
    return ResponseEntity
        .created(URI.create(emailCustomer))
        .build();
  }

  @Override
  @PostMapping(value = "/send", consumes = APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> saveAndSend(
      @RequestBody @Valid CollectionEmailDTO collectionEmailDTO) {
    emailService.sendEmailToCustomerAndSave(collectionEmailDTO);
    final String emailCustomer = collectionEmailDTO.getEmailCustomer();
    return ResponseEntity
        .created(URI.create(emailCustomer))
        .build();
  }

  @Override
  @DeleteMapping(value = "/delete/{id}")
  public ResponseEntity<Void> deleteEmail(@PathVariable Integer id) {
    emailService.deleteEmail(id);
    return ResponseEntity
        .noContent()
        .build();
  }
}
