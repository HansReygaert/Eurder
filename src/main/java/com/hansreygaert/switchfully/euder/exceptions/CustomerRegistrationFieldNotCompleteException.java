package com.hansreygaert.switchfully.euder.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(reason = "Some fields were left blank")
public class CustomerRegistrationFieldNotCompleteException extends ResponseStatusException {

  public static final String DEFAULT_REPLY = "Registration failed, some fields left empty";
  private final Logger logger = LoggerFactory.getLogger(
      CustomerRegistrationFieldNotCompleteException.class);

  public CustomerRegistrationFieldNotCompleteException(String message) {
    super(HttpStatus.BAD_REQUEST, DEFAULT_REPLY);
    logger.warn(message);
  }

  public CustomerRegistrationFieldNotCompleteException() {
    this(DEFAULT_REPLY);
  }
}
