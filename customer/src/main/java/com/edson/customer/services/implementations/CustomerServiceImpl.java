package com.edson.customer.services.implementations;

import com.edson.customer.controllers.dto.request.CustomerRequestDTO;
import com.edson.customer.controllers.dto.response.CustomerResponseDTO;
import com.edson.customer.dataproviders.models.Customer;
import com.edson.customer.dataproviders.models.CustomerAddress;
import com.edson.customer.dataproviders.repositories.CustomerRepository;
import com.edson.customer.services.CustomerService;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CustomerServiceImpl
 *
 * @author : Edson Costa
 * @since : 30/04/2021
 **/
@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public List<CustomerResponseDTO> findAll() {
    final List<Customer> customers = customerRepository.findAll();
    return customers
        .stream()
        .map(CustomerResponseDTO::convertFromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public CustomerResponseDTO findByDocument(final String document) {
    final Customer byDocument = customerRepository.findByDocument(document)
        .orElseThrow(() -> new CustomerNotFoundException("Customer not found."));

    return CustomerResponseDTO.convertFromEntity(byDocument);
  }

  @Override
  @Transactional(rollbackOn = Exception.class)
  public CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO) {
    final Customer customer = customerRepository
        .findByDocument(customerRequestDTO.getDocument())
        .orElseThrow(() -> new CustomerNotFoundException("Customer not found."));

    customer.setFirstName(customerRequestDTO.getFirstName());
    customer.setLastName(customerRequestDTO.getLastName());
    customer.setDocument(customerRequestDTO.getDocument());
    customer.setMobile(customerRequestDTO.getMobile());
    customer.setEmail(customerRequestDTO.getEmail());
    customer.setTotalDebtValue(customerRequestDTO.getTotalDebtValue());
    customer.setDebitStartDate(customerRequestDTO.getDebitStartDate());
    customer.setDescription(customerRequestDTO.getDescription());
    customer.setCustomerAddress(CustomerAddress
        .convertFromRequest(customerRequestDTO.getCustomerAddressRequestDTO()));

    return CustomerResponseDTO.convertFromEntity(customer);
  }

  @Transactional(rollbackOn = Exception.class)
  public void saveCustomer(final CustomerRequestDTO customerRequestDTO) {
    final Customer customer = Customer.convertFromRequest(customerRequestDTO);

    customerRepository.save(customer);
  }

  @Override
  @Transactional(rollbackOn = Exception.class)
  public void deleteCustomer(final String document) {
    final Customer customer = customerRepository.findByDocument(document)
        .orElseThrow(() -> new CustomerNotFoundException("Customer not found."));

    customerRepository.delete(customer);
  }

  public static class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message) {
      super(message);
    }
  }
}
