package com.edson.collectionemail.config;

import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * MailConfig
 *
 * @author : Edson Costa
 * @since : 02/05/2021
 **/
@Slf4j
@Configuration
public class MailConfig {

  @Bean
  public JavaMailSender setUpMailSender() {
    log.info("start configuration for email sender");
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setDefaultEncoding("UTF-8");

    mailSender.setHost("smtp.gmail.com");
    mailSender.setPort(587);

    mailSender.setUsername("teste.renegocicao@gmail.com");
    mailSender.setPassword("testerenegociacao1!");

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.connectiontimeout", 10000);

    return mailSender;
  }
}
