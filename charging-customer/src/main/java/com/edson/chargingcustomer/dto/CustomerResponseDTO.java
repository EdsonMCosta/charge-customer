package com.edson.chargingcustomer.dto;

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
    final var CustomerResponseDTO = new CustomerResponseDTO();

    CustomerResponseDTO.setFirstName(Objects.requireNonNull(customer.getFirstName()));
    CustomerResponseDTO.setLastName(Objects.requireNonNull(customer.getLastName()));
    CustomerResponseDTO.setDocument(Objects.requireNonNull(customer.getDocument()));
    CustomerResponseDTO.setMobile(Objects.requireNonNull(customer.getMobile()));
    CustomerResponseDTO.setEmail(Objects.requireNonNull(customer.getEmail()));
    CustomerResponseDTO.setTotalDebtValue(Objects.requireNonNull(customer.getTotalDebtValue()));
    CustomerResponseDTO.setDebitStartDate(Objects.requireNonNull(customer.getDebitStartDate()));
    CustomerResponseDTO.setDescription(customer.getDescription());
    CustomerResponseDTO.setCustomerAddressResponseDTO(
        Objects.requireNonNull(
            CustomerAddressResponseDTO.convertFromEntity(customer.getCustomerAddress())));

    return CustomerResponseDTO;
  }

}
