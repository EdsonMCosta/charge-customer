package com.edson.customer.controllers.entrypoints.implementations;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.edson.customer.controllers.dto.request.CustomerRequestDTO;
import com.edson.customer.controllers.dto.response.CustomerResponseDTO;
import com.edson.customer.controllers.entrypoints.CustomerController;
import com.edson.customer.services.CustomerService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerControllerImpl implements CustomerController {

  private final CustomerService customerService;

  @Override
  @GetMapping(value = "/list")
  public ResponseEntity<List<CustomerResponseDTO>> getCustomers() {
    final var allCustomers = customerService.findAll();
    return ResponseEntity.ok(allCustomers);
  }

  @Override
  @GetMapping(value = "/{document}")
  public ResponseEntity<CustomerResponseDTO> findByDocument(@PathVariable String document) {
    final var byDocument = customerService.findByDocument(document);

    return ResponseEntity
        .ok(byDocument);
  }

  @Override
  @PostMapping(value = "/create", consumes = APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> createCustomer(
      @RequestBody @Valid final CustomerRequestDTO customerRequestDTO) {
    customerService.saveCustomer(customerRequestDTO);
    final var document = customerRequestDTO.getDocument();
    return ResponseEntity
        .created(URI.create(document))
        .build();
  }

  @Override
  @PutMapping(value = "/update", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<CustomerResponseDTO> updateCustomer(
      @RequestBody @Valid final CustomerRequestDTO customerRequestDTO) {

    final var responseDTO = customerService.updateCustomer(customerRequestDTO);

    return ResponseEntity
        .ok(responseDTO);
  }

  @Override
  @DeleteMapping(value = "/delete/{document}")
  public ResponseEntity<Void> deleteCustomer(@PathVariable String document) {
    customerService.deleteCustomer(document);
    return ResponseEntity
        .noContent()
        .build();
  }


}

