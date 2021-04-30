package com.edson.customer.controllers.entrypoints;

import com.edson.customer.controllers.dto.request.CustomerRequestDTO;
import com.edson.customer.controllers.dto.response.CustomerResponseDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * CustomerController
 *
 * @author : Edson Costa
 * @since : 30/04/2021
 **/
public interface CustomerController {

  ResponseEntity<List<CustomerResponseDTO>> getCustomers();

  ResponseEntity<CustomerResponseDTO> findByDocument(String document);

  ResponseEntity<Void> createCustomer(CustomerRequestDTO customerRequestDTO);

  ResponseEntity<CustomerResponseDTO> updateCustomer(CustomerRequestDTO customerRequestDTO);

  ResponseEntity<Void> deleteCustomer(String document);
}
