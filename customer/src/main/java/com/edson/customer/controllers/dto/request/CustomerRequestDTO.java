package com.edson.customer.controllers.dto.request;

import com.edson.customer.dataproviders.models.Customer;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * CustomerRequestDTO
 *
 * @author : Edson Costa
 * @since : 29/04/2021
 **/
@Data
public class CustomerRequestDTO {

  @NotBlank(message = "First name should be informed.")
  private String firstName;

  @NotBlank(message = "Last name should be informed.")
  private String lastName;

  @NotBlank(message = "Mobile should be informed.")
  private String mobile;

  @NotBlank(message = "Document should be informed.")
  private String document;

  @NotBlank(message = "Email should be informed.")
  private String email;

  @NotBlank(message = "Total debt value.")
  private BigDecimal totalDebtValue;

  @NotBlank(message = "Debit start at.")
  private LocalDate debitStartDate;

  private String description;

  @NotBlank(message = "Complete address should be informed.")
  private CustomerAddressRequestDTO customerAddressRequestDTO;

  public static CustomerRequestDTO convertFromEntity(final Customer customer) {
    final var customerRequestDTO = new CustomerRequestDTO();

    customerRequestDTO.setFirstName(Objects.requireNonNull(customer.getFirstName()));
    customerRequestDTO.setLastName(Objects.requireNonNull(customer.getLastName()));
    customerRequestDTO.setDocument(Objects.requireNonNull(customer.getDocument()));
    customerRequestDTO.setMobile(Objects.requireNonNull(customer.getMobile()));
    customerRequestDTO.setEmail(Objects.requireNonNull(customer.getEmail()));
    customerRequestDTO.setTotalDebtValue(Objects.requireNonNull(customer.getTotalDebtValue()));
    customerRequestDTO.setDebitStartDate(Objects.requireNonNull(customer.getDebitStartDate()));
    customerRequestDTO.setDescription(customer.getDescription());
    customerRequestDTO.setCustomerAddressRequestDTO(
        Objects.requireNonNull(
            CustomerAddressRequestDTO.convertFromEntity(customer.getCustomerAddress())));

    return customerRequestDTO;
  }
}
