package com.edson.customer.dataproviders.models;

import com.edson.customer.controllers.dto.request.CustomerRequestDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 * Customer
 *
 * @author : Edson Costa
 * @since : 29/04/2021
 **/
@Data
@Entity(name = "customer")
@Table(name = "customers")
public class Customer {

  @Id
  @Column(name = "customer_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long customerId;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "document", nullable = false)
  private String document;

  @Column(name = "mobile", nullable = false)
  private String mobile;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "total_debt_value", nullable = false)
  private BigDecimal totalDebtValue;

  @Column(name = "debit_start_date", nullable = false)
  private LocalDate debitStartDate;

  @Column(name = "description")
  private String description;

  @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
      CascadeType.REMOVE}, fetch = FetchType.EAGER, orphanRemoval = true)
  @JoinColumn(name = "customer_address_id")
  private CustomerAddress customerAddress;

  public Customer() {
  }

  public static Customer convertFromRequest(CustomerRequestDTO customerRequestDTO) {
    final Customer customer = new Customer();

    customer.setFirstName(Objects.requireNonNull(customerRequestDTO.getFirstName()));
    customer.setLastName(Objects.requireNonNull(customerRequestDTO.getLastName()));
    customer.setDocument(Objects.requireNonNull(customerRequestDTO.getDocument()));
    customer.setMobile(Objects.requireNonNull(customerRequestDTO.getMobile()));
    customer.setEmail(Objects.requireNonNull(customerRequestDTO.getEmail()));
    customer.setTotalDebtValue(Objects.requireNonNull(customerRequestDTO.getTotalDebtValue()));
    customer.setDebitStartDate(Objects.requireNonNull(customerRequestDTO.getDebitStartDate()));
    customer.setDescription(customerRequestDTO.getDescription());
    customer.setCustomerAddress(
        Objects.requireNonNull(
            CustomerAddress.convertFromRequest(customerRequestDTO.getCustomerAddressRequestDTO())));

    return customer;
  }
}
