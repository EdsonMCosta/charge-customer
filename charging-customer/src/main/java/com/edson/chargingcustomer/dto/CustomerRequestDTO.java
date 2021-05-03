package com.edson.chargingcustomer.dto;

import com.edson.customer.dataproviders.models.Customer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * CustomerRequestDTO
 *
 * @author : Edson Costa
 * @since : 29/04/2021
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO {

  @NotBlank(message = "First name should be informed.")
  private String firstName;

  @NotBlank(message = "Last name should be informed.")
  private String lastName;

  @NotBlank(message = "Mobile should be informed.")
  private String mobile;

  @NotBlank(message = "Document should be informed.")
  private String document;

  @Email(message = "Email should be informed.")
  private String email;

  @NotNull(message = "Total debt value.")
  @PositiveOrZero
  private BigDecimal totalDebtValue;

  @NotNull(message = "Debit start at.")
  @JsonFormat(pattern = "dd/MM/yyyy")
  @DateTimeFormat(iso = ISO.DATE)
  private LocalDate debitStartDate;

  private String description;

  @NotBlank(message = "Complete address should be informed.")
  @JsonProperty(value = "address")
  private com.edson.customer.controllers.dto.request.CustomerAddressRequestDTO customerAddressRequestDTO;

  public static CustomerRequestDTO convertFromEntity(Customer customer) {
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
            com.edson.customer.controllers.dto.request.CustomerAddressRequestDTO.convertFromEntity(customer.getCustomerAddress())));

    return customerRequestDTO;
  }
}
