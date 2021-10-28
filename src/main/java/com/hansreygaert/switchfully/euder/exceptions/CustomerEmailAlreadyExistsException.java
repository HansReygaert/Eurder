package com.hansreygaert.switchfully.euder.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomerEmailAlreadyExistsException extends ResponseStatusException {
	private final Logger logger = LoggerFactory.getLogger(CustomerEmailAlreadyExistsException.class);
	public static final String DEFAULT_REPLY = "Email already in use";

	public CustomerEmailAlreadyExistsException(String message) {
		super(HttpStatus.BAD_REQUEST);
		logger.warn(message);
	}

	public CustomerEmailAlreadyExistsException() {
		super(HttpStatus.BAD_REQUEST);
		logger.warn(DEFAULT_REPLY);
	}
}
