package com.edson.converter;

import com.edson.collectionemail.controllers.dtos.EmailDTO;
import com.edson.collectionemail.dataproviders.models.Email;

/**
 * DTOConverter
 *
 * @author : Edson Costa
 * @since : 02/05/2021
 **/
public class DTOConverter {

  public static EmailDTO convertFromEntity(Email email) {
    final EmailDTO emailDTO = new EmailDTO();

    emailDTO.setEmailCustomer(email.getEmailCustomer());
    emailDTO.setFirstNameCustomer(email.getFirstNameCustomer());
    emailDTO.setLastNameCustomer(email.getLastNameCustomer());
    emailDTO.setDocumentCustomer(email.getDocumentCustomer());
    emailDTO.setTotalDebitValue(email.getTotalDebitValue());
    emailDTO.setDebitStartDate(email.getDebitStartDate());
    emailDTO.setDescription(email.getDescription());

    return emailDTO;
  }

}
