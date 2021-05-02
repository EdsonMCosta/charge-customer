package com.edson.collectionemail.dataproviders.repositories;

import com.edson.collectionemail.dataproviders.models.Email;
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

}
