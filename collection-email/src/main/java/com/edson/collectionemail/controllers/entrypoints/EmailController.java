package com.edson.collectionemail.controllers.entrypoints;

import com.edson.collectionemail.controllers.dtos.CollectionEmailDTO;
import com.edson.collectionemail.controllers.dtos.EmailDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 * EmailController
 *
 * @author : Edson Costa
 * @since : 02/05/2021
 **/
public interface EmailController {

  ResponseEntity<List<EmailDTO>> getAllEmails();

  ResponseEntity<EmailDTO> findByDocumentCustomer(String documentCustomer);

  ResponseEntity<Void> createEmail(EmailDTO emailDTO);

  ResponseEntity<Void> saveAndSend (CollectionEmailDTO collectionEmailDTO);

  ResponseEntity<Void> deleteEmail(Integer id);

}
