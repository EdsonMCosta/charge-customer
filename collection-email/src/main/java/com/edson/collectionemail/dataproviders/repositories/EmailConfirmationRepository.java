package com.edson.collectionemail.dataproviders.repositories;

import com.edson.collectionemail.dataproviders.models.EmailConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EmailConfirmationRepository
 *
 * @author : Edson Costa
 * @since : 01/05/2021
 **/
@Repository
public interface EmailConfirmationRepository extends JpaRepository<EmailConfirmation, Integer> {

}
