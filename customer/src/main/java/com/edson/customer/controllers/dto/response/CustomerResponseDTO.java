package com.edson.customer.controllers.dto.response;

import com.edson.customer.dataproviders.models.Customer;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import lombok.Setter;

/**
 * CustomerResponseDTO
 *
 * @author : Edson Costa
 * @since : 30/04/2021
 **/
@Setter
public class CustomerResponseDTO {

  private String firstName;

  private String lastName;

  private String mobile;

  private String document;

  private String email;

  private BigDecimal totalDebtValue;

  private LocalDate debitStartDate;

  private String description;

  private CustomerAddressResponseDTO customerAddressResponseDTO;

  public static CustomerResponseDTO convertFromEntity(final Customer customer) {
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
