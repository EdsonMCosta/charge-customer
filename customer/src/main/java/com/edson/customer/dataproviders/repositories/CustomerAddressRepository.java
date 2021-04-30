package com.edson.customer.dataproviders.repositories;

import com.edson.customer.dataproviders.models.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CustomerAddressRepository
 *
 * @author : Edson Costa
 * @since : 30/04/2021
 **/
@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Long> {

}
