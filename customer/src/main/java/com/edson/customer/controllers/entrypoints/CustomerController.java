package com.edson.customer.controllers.entrypoints;

import com.edson.customer.controllers.dto.request.CustomerRequestDTO;
import com.edson.customer.controllers.dto.response.CustomerResponseDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 * CustomerController
 *
 * @author : Edson Costa
 * @since : 30/04/2021
 **/
public interface CustomerController {

  ResponseEntity<List<CustomerResponseDTO>> getAllCustomers();

  ResponseEntity<CustomerResponseDTO> findByDocument(String document);

  ResponseEntity<Void> createCustomer(CustomerRequestDTO customerRequestDTO);

  ResponseEntity<CustomerResponseDTO> updateCustomer(CustomerRequestDTO customerRequestDTO);

  ResponseEntity<Void> deleteCustomer(String document);
}
