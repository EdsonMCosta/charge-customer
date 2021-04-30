package com.edson.customer.controllers.entrypoints.implementations;

import com.edson.customer.controllers.dto.request.CustomerRequestDTO;
import com.edson.customer.controllers.dto.response.CustomerResponseDTO;
import com.edson.customer.controllers.entrypoints.CustomerController;
import com.edson.customer.services.CustomerService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CustomerControllerImpl
 *
 * @author : Edson Costa
 * @since : 30/04/2021
 **/
@RestController
@RequestMapping("/customer")
public class CustomerControllerImpl implements CustomerController {

  @Autowired
  private CustomerService customerService;

  @Override
  @GetMapping("/list")
  public ResponseEntity<List<CustomerResponseDTO>> getCustomers() {
    final var all = customerService.findAll();

    return ResponseEntity
        .ok(all);
  }

  @Override
  @GetMapping("/{document}")
  public ResponseEntity<CustomerResponseDTO> findByDocument(@PathVariable String document) {
    final var byDocument = customerService.findByDocument(document);

    return ResponseEntity
        .ok(byDocument);
  }

  @Override
  public ResponseEntity<Void> createCustomer(CustomerRequestDTO customerRequestDTO) {
    customerService.saveCustomer(customerRequestDTO);
    final var document = customerRequestDTO.getDocument();
    return ResponseEntity
        .created(URI.create(document))
        .build();
  }

  @Override
  public ResponseEntity<CustomerResponseDTO> updateCustomer(
      @RequestBody CustomerRequestDTO customerRequestDTO) {

    final var responseDTO = customerService.updateCustomer(customerRequestDTO);

    return ResponseEntity
        .ok(responseDTO);
  }

  @Override
  public ResponseEntity<Void> deleteCustomer(String document) {
    customerService.deleteCustomer(document);
    return ResponseEntity
        .noContent()
        .build();
  }


}
