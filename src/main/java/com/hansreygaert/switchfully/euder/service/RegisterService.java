package com.hansreygaert.switchfully.euder.service;

import com.hansreygaert.switchfully.euder.domain.repository.CustomerRepository;
import com.hansreygaert.switchfully.euder.dtos.IdentificationDto;
import com.hansreygaert.switchfully.euder.dtos.RegistrationDto;
import com.hansreygaert.switchfully.euder.exceptions.UserRegistrationFieldNotCompleteException;
import com.hansreygaert.switchfully.euder.mappers.RegistrationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
	private final CustomerRepository customerRepository;
	private final SecurityService securityService;
	private final Logger logger = LoggerFactory.getLogger(RegisterService.class);

	public RegisterService(CustomerRepository customerRepository,
	                       SecurityService securityService) {
		this.customerRepository = customerRepository;
		this.securityService = securityService;
	}

	public IdentificationDto register(RegistrationDto registrationField){
			//TODO: Turn these in another exception
		if (isRegistrationFieldComplete(registrationField))
			throw new UserRegistrationFieldNotCompleteException("Registration " +
					  "failed, fields empty");
		if(isUniqueEmail(registrationField.email())) throw new RuntimeException();

		customerRepository.addCustomer(
				  RegistrationMapper.getCustomerFromDto(registrationField)
		);
		logger.info("New customer added");
		return securityService.getIdentificationToken(registrationField.email());
	}

	private boolean isRegistrationFieldComplete(RegistrationDto registrationField){
		return registrationField.firstName() != null
				  && registrationField.lastName() != null
				  && registrationField.email() != null
				  && registrationField.address() != null
				  && registrationField.phoneNumber() != null;
	}

	private boolean isUniqueEmail(String emailField) {
		return customerRepository.getCustomers().stream()
				  .noneMatch(email -> email.getEmail().equals(emailField));
	}
}
