package com.edson.collectionemail.controllers.dtos;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;

/**
 * CollectionEmailDTO
 *
 * @author : Edson Costa
 * @since : 04/05/2021
 **/
public class CollectionEmailDTO implements Serializable {

  @NotBlank
  private String emailCustomer;

  @NotBlank
  private String documentCustomer;

  @NotBlank
  private String key;

  public String getEmailCustomer() {
    return emailCustomer;
  }

  public void setEmailCustomer(String emailCustomer) {
    this.emailCustomer = emailCustomer;
  }

  public String getDocumentCustomer() {
    return documentCustomer;
  }

  public void setDocumentCustomer(String documentCustomer) {
    this.documentCustomer = documentCustomer;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }
}
