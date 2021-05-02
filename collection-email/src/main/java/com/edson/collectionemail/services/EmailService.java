package com.edson.collectionemail.services;

import com.edson.collectionemail.controllers.dtos.EmailDTO;
import java.util.List;

/**
 * EmailService
 *
 * @author : Edson Costa
 * @since : 02/05/2021
 **/
public interface EmailService {

  List<EmailDTO> findAll();

  EmailDTO findByDocumentCustomer(String documentCustomer);

  void saveEmail(EmailDTO emailDTO);

  void deleteEmail(Integer id);

}
