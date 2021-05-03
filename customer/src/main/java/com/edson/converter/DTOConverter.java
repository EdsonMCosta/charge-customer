package com.edson.converter;

import com.edson.customer.controllers.dto.request.CustomerAddressRequestDTO;
import com.edson.customer.controllers.dto.request.CustomerRequestDTO;
import com.edson.customer.controllers.dto.response.CustomerAddressResponseDTO;
import com.edson.customer.controllers.dto.response.CustomerResponseDTO;
import com.edson.customer.dataproviders.models.Customer;
import com.edson.customer.dataproviders.models.CustomerAddress;
import java.util.Objects;

/**
 * DTOConverter
 *
 * @author : Edson Costa
 * @since : 02/05/2021
 **/
public class DTOConverter {

  public static CustomerAddressRequestDTO convertFromEntity(CustomerAddress customerAddress) {
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
            CustomerAddressRequestDTO.convertFromEntity(customer.getCustomerAddress())));

    return customerRequestDTO;
  }

  public static CustomerAddressResponseDTO convertResponseFromEntity(CustomerAddress customerAddress) {
    final var customerAddressResponseDTO = new CustomerAddressResponseDTO();

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

  public static CustomerResponseDTO convertResponseFromEntity(Customer customer) {
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
