package com.edson.collectionemail.services.implementations;

import com.edson.collectionemail.controllers.dtos.CustomerResponseDTO;
import com.edson.collectionemail.services.CustomerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * CustomerServiceImpl
 *
 * @author : Edson Costa
 * @since : 02/05/2021
 **/
@Service
public class CustomerServiceImpl implements CustomerService {

  @Value("${CUSTOMER_API_URL:http://localhost:8080/api}")
  private String customerApiURL;

  @Override
  public CustomerResponseDTO getCustomerByDocument(String document) {
    try {
      RestTemplate restTemplate = new RestTemplate();

      UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(
          customerApiURL + "/customer/" + document);

      ResponseEntity<CustomerResponseDTO> response = restTemplate
          .getForEntity(builder.toUriString(), CustomerResponseDTO.class);

      return response.getBody();

    } catch (HttpClientErrorException.NotFound e) {
      throw new RuntimeException();
    }
  }
}
