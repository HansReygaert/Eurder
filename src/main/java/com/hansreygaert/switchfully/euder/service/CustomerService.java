package com.hansreygaert.switchfully.euder.service;

import com.hansreygaert.switchfully.euder.domain.repository.CustomerRepository;
import com.hansreygaert.switchfully.euder.dtos.CustomerDto;
import com.hansreygaert.switchfully.euder.dtos.CustomerDtoBasicInformation;
import com.hansreygaert.switchfully.euder.dtos.IdentificationDto;
import com.hansreygaert.switchfully.euder.dtos.CustomerRegistrationDto;
import com.hansreygaert.switchfully.euder.exceptions.CustomerEmailAlreadyExistsException;
import com.hansreygaert.switchfully.euder.exceptions.CustomerRegistrationFieldNotCompleteException;
import com.hansreygaert.switchfully.euder.mappers.CustomerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
	private final CustomerRepository customerRepository;
	private final SecurityService securityService;
	private final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	public CustomerService(CustomerRepository customerRepository,
	                       SecurityService securityService) {
		this.customerRepository = customerRepository;
		this.securityService = securityService;
	}

	public IdentificationDto register(CustomerRegistrationDto registrationField){
		if (! isRegistrationFieldComplete(registrationField))
			throw new CustomerRegistrationFieldNotCompleteException();
		if(! isUniqueEmail(registrationField.email()))
			throw new CustomerEmailAlreadyExistsException();

		customerRepository.addCustomer(
				  CustomerMapper.getCustomerFromDto(registrationField)
		);
		logger.info("New customer added");
		return securityService.getIdentificationToken(registrationField.email());
	}

	private boolean isRegistrationFieldComplete(CustomerRegistrationDto customerRegistrationForm){
		return customerRegistrationForm.firstName() != null
				  && customerRegistrationForm.lastName() != null
				  && customerRegistrationForm.email() != null
				  && customerRegistrationForm.address() != null
				  && customerRegistrationForm.phoneNumber() != null;
	}

	private boolean isUniqueEmail(String emailField) {
		return customerRepository.getCustomers().stream()
				  .noneMatch(email -> email.getEmail().equals(emailField));
	}

	public CustomerDto getCustomerInformation(String identificationToken,
	                                          String uuid){
		if (!securityService.isAdmin(identificationToken)) return null;
		return CustomerMapper.getCustomerDto(customerRepository.getCustomerById(uuid));
	}

	public List<CustomerDtoBasicInformation> getAllCustomers(String identificationToken){
		if (!securityService.isAdmin(identificationToken)) return null;
		return customerRepository.getCustomers()
				  .stream()
				  .map(CustomerMapper :: getCustomerDtoBasicInfo)
				  .toList();
	}
}
