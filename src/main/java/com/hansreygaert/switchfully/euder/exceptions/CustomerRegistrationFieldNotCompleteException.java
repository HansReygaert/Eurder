package com.hansreygaert.switchfully.euder.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomerRegistrationFieldNotCompleteException extends ResponseStatusException {
	private final Logger logger = LoggerFactory.getLogger(CustomerRegistrationFieldNotCompleteException.class);
	public static final String DEFAULT_REPLY =
			  "Registration failed, some fields left empty";
	public CustomerRegistrationFieldNotCompleteException(String message) {
		super(HttpStatus.BAD_REQUEST);
		logger.warn(message);
	}

	public CustomerRegistrationFieldNotCompleteException() {
		super(HttpStatus.BAD_REQUEST);
		logger.warn(DEFAULT_REPLY);
	}
}
