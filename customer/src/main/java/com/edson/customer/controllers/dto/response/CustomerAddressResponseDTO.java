package com.edson.customer.controllers.dto.response;

import com.edson.customer.dataproviders.models.CustomerAddress;
import java.io.Serializable;
import java.util.Objects;
import lombok.Data;

/**
 * CustomerAddressResponseDTO
 *
 * @author : Edson Costa
 * @since : 30/04/2021
 **/
@Data
public class CustomerAddressResponseDTO implements Serializable {

  private String street;

  private String number;

  private String complement;

  private String postalCode;

  private String neighborhood;

  private String city;

  private String state;

  public static CustomerAddressResponseDTO convertFromEntity(CustomerAddress customerAddress) {
    final CustomerAddressResponseDTO customerAddressResponseDTO = new CustomerAddressResponseDTO();

    customerAddressResponseDTO.setStreet(Objects.requireNonNull(customerAddress.getStreet()));
    customerAddressResponseDTO.setNumber(Objects.requireNonNull(customerAddress.getNumber()));
    customerAddressResponseDTO.setComplement(customerAddress.getComplement());
    customerAddressResponseDTO
        .setPostalCode(Objects.requireNonNull(customerAddress.getPostalCode()));
    customerAddressResponseDTO
        .setNeighborhood(Objects.requireNonNull(customerAddress.getNeighborhood()));
    customerAddressResponseDTO.setCity(Objects.requireNonNull(customerAddress.getCity()));
    customerAddressResponseDTO.setState(Objects.requireNonNull(customerAddress.getState()));

    return customerAddressResponseDTO;

  }

}
