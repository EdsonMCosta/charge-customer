package com.edson.collectionemail.controllers.dtos;

import java.io.Serializable;
import lombok.Value;

/**
 * EmailResultDTO
 *
 * @author : Edson Costa
 * @since : 02/05/2021
 **/
@Value
public class EmailResultDTO implements Serializable {

  Boolean success;
  String message;

  public EmailResultDTO(Boolean success, String message) {
    this.success = success;
    this.message = message;
  }

  public static EmailResultDTO of(final Boolean success, final String message) {
    return new EmailResultDTO(success, message);
  }
}
