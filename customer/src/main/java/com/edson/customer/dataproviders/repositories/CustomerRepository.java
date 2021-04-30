package com.edson.customer.dataproviders.repositories;

import com.edson.customer.dataproviders.models.Customer;
import java.util.Optional;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * CustomerRepository
 *
 * @author : Edson Costa
 * @since : 30/04/2021
 **/
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  @ReadOnlyProperty
  Optional<Customer> findByDocument(final String document);
}
