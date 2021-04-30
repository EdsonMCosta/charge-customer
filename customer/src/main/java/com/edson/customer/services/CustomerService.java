package com.edson.customer.services;

import com.edson.customer.controllers.dto.request.CustomerRequestDTO;
import com.edson.customer.controllers.dto.response.CustomerResponseDTO;
import java.util.List;

/**
 * CustomerService
 *
 * @author : Edson Costa
 * @since : 30/04/2021
 **/
public interface CustomerService {

  List<CustomerResponseDTO> findAll();

  CustomerResponseDTO findByDocument(final String document);

  void saveCustomer(final CustomerRequestDTO customerRequestDTO);

  CustomerResponseDTO updateCustomer(final CustomerRequestDTO customerRequestDTO);

  void deleteCustomer(final String document);
}
