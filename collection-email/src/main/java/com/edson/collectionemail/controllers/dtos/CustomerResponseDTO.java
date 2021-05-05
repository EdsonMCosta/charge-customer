package com.edson.collectionemail.controllers.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

/**
 * CustomerResponseDTO
 *
 * @author : Edson Costa
 * @since : 03/05/2021
 **/
public class CustomerResponseDTO implements Serializable {

    private String key;

    private String firstName;

    private String lastName;

    private String mobile;

    private String document;

    private String email;

    private BigDecimal totalDebtValue;

    private LocalDate debitStartDate;

    private String description;

    private CustomerAddressResponseDTO customerAddressResponseDTO;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getTotalDebtValue() {
        return totalDebtValue;
    }

    public void setTotalDebtValue(BigDecimal totalDebtValue) {
        this.totalDebtValue = totalDebtValue;
    }

    public LocalDate getDebitStartDate() {
        return debitStartDate;
    }

    public void setDebitStartDate(LocalDate debitStartDate) {
        this.debitStartDate = debitStartDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CustomerAddressResponseDTO getCustomerAddressResponseDTO() {
        return customerAddressResponseDTO;
    }

    public void setCustomerAddressResponseDTO(
        CustomerAddressResponseDTO customerAddressResponseDTO) {
        this.customerAddressResponseDTO = customerAddressResponseDTO;
    }
}
