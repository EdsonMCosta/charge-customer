package com.edson.collectionemail.dataproviders.models;

import com.edson.collectionemail.controllers.dtos.EmailDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Email
 *
 * @author : Edson Costa
 * @since : 01/05/2021
 **/
@Entity(name = "email")
@Table(name = "emails")
public class Email {

  @Id
  @Column(name = "email_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer emailId;

  @Column(name = "email_customer", nullable = false)
  private String emailCustomer;

  @Column(name = "first_name_customer", nullable = false)
  private String firstNameCustomer;

  @Column(name = "last_name_customer", nullable = false)
  private String lastNameCustomer;

  @Column(name = "document_customer", nullable = false)
  private String documentCustomer;

  @Column(name = "total_debit_value", nullable = false)
  private BigDecimal totalDebitValue;

  @Column(name = "debit_start_date", nullable = false)
  private LocalDate debitStartDate;

  @Column(name = "description")
  private String description;

  public Email() {
  }

  public Email(Integer emailId, String emailCustomer, String firstNameCustomer,
      String lastNameCustomer, String documentCustomer, BigDecimal totalDebitValue,
      LocalDate debitStartDate, String description) {
    this.emailId = emailId;
    this.emailCustomer = emailCustomer;
    this.firstNameCustomer = firstNameCustomer;
    this.lastNameCustomer = lastNameCustomer;
    this.documentCustomer = documentCustomer;
    this.totalDebitValue = totalDebitValue;
    this.debitStartDate = debitStartDate;
    this.description = description;
  }

  public Integer getEmailId() {
    return emailId;
  }

  public void setEmailId(Integer emailId) {
    this.emailId = emailId;
  }

  public String getEmailCustomer() {
    return emailCustomer;
  }

  public void setEmailCustomer(String emailCustomer) {
    this.emailCustomer = emailCustomer;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Email)) {
      return false;
    }
    Email email = (Email) o;
    return emailId.equals(email.emailId) && emailCustomer.equals(email.emailCustomer)
        && firstNameCustomer.equals(email.firstNameCustomer) && lastNameCustomer
        .equals(email.lastNameCustomer) && documentCustomer.equals(email.documentCustomer)
        && totalDebitValue.equals(email.totalDebitValue) && debitStartDate
        .equals(email.debitStartDate) && description.equals(email.description);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(emailId, emailCustomer, firstNameCustomer, lastNameCustomer, documentCustomer,
            totalDebitValue, debitStartDate, description);
  }

  @Override
  public String toString() {
    return "Email{" +
        "emailId=" + emailId +
        ", emailCustomer='" + emailCustomer + '\'' +
        ", firstNameCustomer='" + firstNameCustomer + '\'' +
        ", lastNameCustomer='" + lastNameCustomer + '\'' +
        ", documentCustomer='" + documentCustomer + '\'' +
        ", totalDebitValue=" + totalDebitValue +
        ", debitStartDate=" + debitStartDate +
        ", description='" + description + '\'' +
        '}';
  }

  public static Email convertFromDTO(EmailDTO emailDTO) {
    final var email = new Email();

    email.setEmailCustomer(emailDTO.getEmailCustomer());
    email.setFirstNameCustomer(emailDTO.getFirstNameCustomer());
    email.setLastNameCustomer(emailDTO.getLastNameCustomer());
    email.setDocumentCustomer(emailDTO.getDocumentCustomer());
    email.setTotalDebitValue(emailDTO.getTotalDebitValue());
    email.setDebitStartDate(emailDTO.getDebitStartDate());
    email.setDescription(emailDTO.getDescription());

    return email;
  }
}
