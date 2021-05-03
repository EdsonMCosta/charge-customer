package com.edson.chargingcustomer.dto;

import java.util.List;

/**
 * EmailSenderService
 *
 * @author : Edson Costa
 * @since : 02/05/2021
 **/
public class EmailSenderDTO {

  public static final String MAIL_SUBJECT = "Comunicado de Renegociação!";

  public static final String SENDER = "contato@renegociacao.com.br";

  private List<String> recipients;

  private String body;

  public EmailSenderDTO(List<String> recipients,
      String body) {
    this.recipients = recipients;
    this.body = body;
  }

  public List<String> getRecipients() {
    return recipients;
  }

  public void setRecipients(List<String> recipients) {
    this.recipients = recipients;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }


}
