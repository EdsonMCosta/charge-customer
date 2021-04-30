package com.edson.customer.dataproviders.entities;

import com.edson.customer.controllers.dto.request.CustomerAddressRequestDTO;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 * CustomerAddress
 *
 * @author : Edson Costa
 * @since : 29/04/2021
 **/
@Data
@Entity(name = "customers_address")
public class CustomerAddress {

  @Id
  @Column(name = "customer_address_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String customerAddressId;

  @Column(name = "street", nullable = false)
  private String street;

  @Column(name = "number", nullable = false)
  private String number;

  @Column(name = "complement")
  private String complement;

  @Column(name = "postalCode", nullable = false)
  private String postalCode;

  @Column(name = "neighborhood", nullable = false)
  private String neighborhood;

  @Column(name = "city", nullable = false)
  private String city;

  @Column(name = "state", nullable = false)
  private String state;

  public CustomerAddress() {
  }

  public static CustomerAddress convertFromRequest(
      final CustomerAddressRequestDTO customerAddressRequestDTO) {
    final var customerAddress = new CustomerAddress();

    customerAddress.setStreet(Objects.requireNonNull(customerAddressRequestDTO.getStreet()));
    customerAddress.setNumber(Objects.requireNonNull(customerAddressRequestDTO.getNumber()));
    customerAddress.setComplement(customerAddressRequestDTO.getComplement());
    customerAddress
        .setPostalCode(Objects.requireNonNull(customerAddressRequestDTO.getPostalCode()));
    customerAddress
        .setNeighborhood(Objects.requireNonNull(customerAddressRequestDTO.getNeighborhood()));
    customerAddress.setCity(Objects.requireNonNull(customerAddressRequestDTO.getCity()));
    customerAddress.setState(Objects.requireNonNull(customerAddressRequestDTO.getState()));

    return customerAddress;
  }
}
