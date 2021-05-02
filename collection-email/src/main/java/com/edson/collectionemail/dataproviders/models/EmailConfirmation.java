package com.edson.collectionemail.dataproviders.models;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * ConfirmationEmail
 *
 * @author : Edson Costa
 * @since : 01/05/2021
 **/
@Entity(name = "email_confirmation")
@Table(name = "emails_confirmation")
public class EmailConfirmation {

  @Id
  @Column(name = "confirmation_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer confirmationId;

  @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
      CascadeType.REMOVE}, fetch = FetchType.EAGER, orphanRemoval = true)
  @JoinColumn(name = "email_id")
  private Email email;

  @Column(name = "was_sent", nullable = false)
  private Boolean wasSent;

  public EmailConfirmation() {
  }

  public EmailConfirmation(Integer confirmationId,
      Email email, Boolean wasSent) {
    this.confirmationId = confirmationId;
    this.email = email;
    this.wasSent = wasSent;
  }

  public Integer getConfirmationId() {
    return confirmationId;
  }

  public void setConfirmationId(Integer confirmationId) {
    this.confirmationId = confirmationId;
  }

  public Email getEmail() {
    return email;
  }

  public void   setEmail(Email email) {
    this.email = email;
  }

  public Boolean getWasSent() {
    return wasSent;
  }

  public void setWasSent(Boolean wasSent) {
    this.wasSent = wasSent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof EmailConfirmation)) {
      return false;
    }
    EmailConfirmation that = (EmailConfirmation) o;
    return confirmationId.equals(that.confirmationId) && email.equals(that.email) && wasSent
        .equals(that.wasSent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(confirmationId, email, wasSent);
  }

  @Override
  public String toString() {
    return "EmailConfirmation{" +
        "confirmationId=" + confirmationId +
        ", email=" + email +
        ", wasSent=" + wasSent +
        '}';
  }
}
