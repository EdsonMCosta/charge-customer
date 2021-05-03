package com.edson.collectionemail.services;

import com.edson.collectionemail.controllers.dtos.CustomerResponseDTO;

/**
 * UserService
 *
 * @author : Edson Costa
 * @since : 02/05/2021
 **/
@FunctionalInterface
public interface CustomerService {

  CustomerResponseDTO getCustomerByDocument(String document);
}
