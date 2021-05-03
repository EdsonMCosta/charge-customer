package com.edson.customer.controllers.dto.response;

import com.edson.customer.dataproviders.models.Customer;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import lombok.Data;

/**
 * CustomerResponseDTO
 *
 * @author : Edson Costa
 * @since : 30/04/2021
 **/
@Data
public class CustomerResponseDTO implements Serializable {

  private String firstName;

  private String lastName;

  private String mobile;

  private String document;

  private String email;

  private BigDecimal totalDebtValue;

  private LocalDate debitStartDate;

  private String description;

  private CustomerAddressResponseDTO customerAddressResponseDTO;

  public static CustomerResponseDTO convertFromEntity(Customer customer) {
    final CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();

    customerResponseDTO.setFirstName(Objects.requireNonNull(customer.getFirstName()));
    customerResponseDTO.setLastName(Objects.requireNonNull(customer.getLastName()));
    customerResponseDTO.setDocument(Objects.requireNonNull(customer.getDocument()));
    customerResponseDTO.setMobile(Objects.requireNonNull(customer.getMobile()));
    customerResponseDTO.setEmail(Objects.requireNonNull(customer.getEmail()));
    customerResponseDTO.setTotalDebtValue(Objects.requireNonNull(customer.getTotalDebtValue()));
    customerResponseDTO.setDebitStartDate(Objects.requireNonNull(customer.getDebitStartDate()));
    customerResponseDTO.setDescription(customer.getDescription());
    customerResponseDTO.setCustomerAddressResponseDTO(
        Objects.requireNonNull(
            CustomerAddressResponseDTO.convertFromEntity(customer.getCustomerAddress())));

    return customerResponseDTO;
  }

}
