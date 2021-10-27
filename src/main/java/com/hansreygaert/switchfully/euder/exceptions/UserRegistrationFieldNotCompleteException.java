package com.hansreygaert.switchfully.euder.exceptions;

import com.hansreygaert.switchfully.euder.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserRegistrationFieldNotCompleteException extends ResponseStatusException {
	private final Logger logger = LoggerFactory.getLogger(UserRegistrationFieldNotCompleteException.class);
	public UserRegistrationFieldNotCompleteException(String message) {
		super(HttpStatus.BAD_REQUEST);
		logger.warn(message);
	}
}
