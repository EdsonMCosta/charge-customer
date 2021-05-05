package com.edson.collectionemail.controllers.dtos;

import com.edson.collectionemail.dataproviders.models.Email;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * EmailDTO
 *
 * @author : Edson Costa
 * @since : 02/05/2021
 **/
public class EmailDTO implements Serializable {

  @NotBlank
  private String emailCustomer;

  @NotBlank
  private String key;

  @NotBlank
  private String firstNameCustomer;

  @NotBlank
  private String lastNameCustomer;

  @NotBlank
  private String documentCustomer;

  @NotNull
  private BigDecimal totalDebitValue;

  @NotNull
  private LocalDate debitStartDate;

  @NotBlank
  private String description;

  public String getEmailCustomer() {
    return emailCustomer;
  }

  public void setEmailCustomer(String emailCustomer) {
    this.emailCustomer = emailCustomer;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getFirstNameCustomer() {
    return firstNameCustomer;
  }

  public void setFirstNameCustomer(String firstNameCustomer) {
    this.firstNameCustomer = firstNameCustomer;
  }

  public String getLastNameCustomer() {
    return lastNameCustomer;
  }

  public void setLastNameCustomer(String lastNameCustomer) {
    this.lastNameCustomer = lastNameCustomer;
  }

  public String getDocumentCustomer() {
    return documentCustomer;
  }

  public void setDocumentCustomer(String documentCustomer) {
    this.documentCustomer = documentCustomer;
  }

  public BigDecimal getTotalDebitValue() {
    return totalDebitValue;
  }

  public void setTotalDebitValue(BigDecimal totalDebitValue) {
    this.totalDebitValue = totalDebitValue;
  }

  public LocalDate getDebitStartDate() {
    return debitStartDate;
  }

  public void setDebitStartDate(LocalDate debitStartDate) {
    this.debitStartDate = debitStartDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public static EmailDTO convertFromEntity(Email email) {
    final EmailDTO emailDTO = new EmailDTO();

    emailDTO.setEmailCustomer(email.getEmailCustomer());
    emailDTO.setKey(email.getKey());
    emailDTO.setFirstNameCustomer(email.getFirstNameCustomer());
    emailDTO.setLastNameCustomer(email.getLastNameCustomer());
    emailDTO.setDocumentCustomer(email.getDocumentCustomer());
    emailDTO.setTotalDebitValue(email.getTotalDebitValue());
    emailDTO.setDebitStartDate(email.getDebitStartDate());
    emailDTO.setDescription(email.getDescription());

    return emailDTO;
  }
}
