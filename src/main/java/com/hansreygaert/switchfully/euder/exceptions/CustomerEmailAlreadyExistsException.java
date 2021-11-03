package com.hansreygaert.switchfully.euder.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(reason = "This email already exists")
public class CustomerEmailAlreadyExistsException extends ResponseStatusException {

  private static final String DEFAULT_REPLY = "Email already in use";
  private final Logger logger = LoggerFactory.getLogger(CustomerEmailAlreadyExistsException.class);

  public CustomerEmailAlreadyExistsException(String message) {
    super(HttpStatus.BAD_REQUEST, message);
    logger.warn(message);
  }

  public CustomerEmailAlreadyExistsException() {
    this(DEFAULT_REPLY);
  }
}
