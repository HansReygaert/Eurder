package com.hansreygaert.switchfully.euder.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(reason = "User not found")
public class CustomerNotFoundException extends ResponseStatusException {
	private final Logger logger = LoggerFactory.getLogger(CustomerNotFoundException.class);
	public static final String DEFAULT_REPLY = "User not found";

	public CustomerNotFoundException(String message) {
		super(HttpStatus.BAD_REQUEST, message);
		logger.warn(message);
	}

	public CustomerNotFoundException() {
		this(DEFAULT_REPLY);
	}
}
