package com.edson.collectionemail.usecase.implementations;

/**
 * PrepareBodyMailUseCase
 *
 * @author : Edson Costa
 * @since : 02/05/2021
 **/
@FunctionalInterface
public interface PrepareBodyMailUseCase {

  String prepareBodyMessage(String documentCustomer);
}
