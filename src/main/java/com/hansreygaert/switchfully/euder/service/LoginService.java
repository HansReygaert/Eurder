package com.hansreygaert.switchfully.euder.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	private final SecurityService securityService;
	private final Logger logger = LoggerFactory.getLogger(LoginService.class);

	public LoginService(SecurityService securityService) {
		this.securityService = securityService;
	}


}
