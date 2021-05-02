package com.edson.collectionemail.usecase;

import com.edson.collectionemail.services.EmailService;
import com.edson.collectionemail.usecase.implementations.PrepareBodyMailUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PrepareBodyMailUseCase
 *
 * @author : Edson Costa
 * @since : 02/05/2021
 **/
@Service
public class PrepareBodyMailUseCaseImpl implements PrepareBodyMailUseCase {

  @Autowired
  private EmailService emailService;

  public String prepareBodyMessage(String documentCustomer) {
    final var byDocumentCustomer = emailService.findByDocumentCustomer(documentCustomer);

    var firstPart = String.format("O senhor: %s", byDocumentCustomer.getFirstNameCustomer());
    var secondPart = String.format("está com uma dívida ativa no valor de: %s",
        byDocumentCustomer.getTotalDebitValue());
    var thirdPart = String.format("referente ao: %s", byDocumentCustomer.getDescription());
    var fourthPart = String
        .format("que teve o vencimento no dia: %s", byDocumentCustomer.getDebitStartDate());
    var fifthPart = "favor entrar em contato com o número 0800-00-001. "
        + "Obrigado.";

    return String.valueOf(new String[]{firstPart, secondPart, thirdPart, fourthPart, fifthPart});
  }

}
