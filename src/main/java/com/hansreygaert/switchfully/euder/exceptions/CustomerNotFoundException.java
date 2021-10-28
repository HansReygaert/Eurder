package com.hansreygaert.switchfully.euder.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomerNotFoundException extends ResponseStatusException {
	private final Logger logger = LoggerFactory.getLogger(CustomerNotFoundException.class);
	public static final String DEFAULT_REPLY = "User not found";

	public CustomerNotFoundException(String message) {
		super(HttpStatus.BAD_REQUEST);
		logger.warn(message);
	}

	public CustomerNotFoundException() {
		super(HttpStatus.BAD_REQUEST);
		logger.warn(DEFAULT_REPLY);
	}
}
