package com.hansreygaert.switchfully.euder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomerEmailAlreadyExistsException extends ResponseStatusException {
	public CustomerEmailAlreadyExistsException() {
		super(HttpStatus.BAD_REQUEST);
	}
}
