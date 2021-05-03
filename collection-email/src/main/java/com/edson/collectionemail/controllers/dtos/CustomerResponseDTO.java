package com.edson.collectionemail.controllers.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * CustomerResponseDTO
 *
 * @author : Edson Costa
 * @since : 03/05/2021
 **/
public class CustomerResponseDTO implements Serializable {

    private String firstName;

    private String lastName;

    private String mobile;

    private String document;

    private String email;

    private BigDecimal totalDebtValue;

    private LocalDate debitStartDate;

    private String description;

    private CustomerAddressResponseDTO customerAddressResponseDTO;

    public String getDocument() {
        return document;
    }
}
