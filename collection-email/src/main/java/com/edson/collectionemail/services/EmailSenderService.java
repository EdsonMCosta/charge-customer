package com.edson.collectionemail.services;

import com.edson.collectionemail.controllers.dtos.EmailDTO;
import com.edson.collectionemail.controllers.dtos.EmailResultDTO;
import com.edson.collectionemail.controllers.dtos.EmailSenderDTO;

/**
 * EmailSenderService
 *
 * @author : Edson Costa
 * @since : 02/05/2021
 **/
@FunctionalInterface
public interface EmailSenderService {

  EmailResultDTO sendEmailToCustomer(EmailSenderDTO emailSenderDTO, EmailDTO emailDTO);
}
