package com.edson.customer.controllers.dto.request;

import com.edson.customer.dataproviders.entities.CustomerAddress;
import java.util.Objects;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * CustomerAddressRequestDTO
 *
 * @author : Edson Costa
 * @since : 29/04/2021
 **/
@Data
public class CustomerAddressRequestDTO {

  @NotBlank(message = "Street should be informed.")
  private String street;

  @NotBlank(message = "Number should be informed.")
  private String number;

  private String complement;

  @NotBlank(message = "Postal code should be informed.")
  private String postalCode;

  @NotBlank(message = "Neighborhood should be informed.")
  private String neighborhood;

  @NotBlank(message = "City should be informed.")
  private String city;

  @NotBlank(message = "State should be informed.")
  private String state;

  public static CustomerAddressRequestDTO convertFromEntity(
      final CustomerAddress customerAddress) {
    final var customerAddressRequestDTO = new CustomerAddressRequestDTO();

    customerAddressRequestDTO.setStreet(Objects.requireNonNull(customerAddress.getStreet()));
    customerAddressRequestDTO.setNumber(Objects.requireNonNull(customerAddress.getNumber()));
    customerAddressRequestDTO.setComplement(customerAddress.getComplement());
    customerAddressRequestDTO
        .setPostalCode(Objects.requireNonNull(customerAddress.getPostalCode()));
    customerAddressRequestDTO
        .setNeighborhood(Objects.requireNonNull(customerAddress.getNeighborhood()));
    customerAddressRequestDTO.setCity(Objects.requireNonNull(customerAddress.getCity()));
    customerAddressRequestDTO.setState(Objects.requireNonNull(customerAddress.getState()));

    return customerAddressRequestDTO;

  }
}

