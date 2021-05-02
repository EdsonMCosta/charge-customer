package com.edson.collectionemail.dataproviders.repositories;

import com.edson.collectionemail.dataproviders.models.Email;
import java.util.Optional;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EmailRepository
 *
 * @author : Edson Costa
 * @since : 01/05/2021
 **/
@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {

  @ReadOnlyProperty
  Optional<Email> findByDocumentCustomer(String document);
}
