package com.hansreygaert.switchfully.euder.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ItemUnexpectedBodyException extends ResponseStatusException {

  private static final String DEFAULT_REPLY = "Illegal body request, can not create item";
  private final Logger logger = LoggerFactory.getLogger(ItemUnexpectedBodyException.class);

  public ItemUnexpectedBodyException() {
    super(HttpStatus.FORBIDDEN, DEFAULT_REPLY);
    logger.warn(DEFAULT_REPLY);
  }
}
