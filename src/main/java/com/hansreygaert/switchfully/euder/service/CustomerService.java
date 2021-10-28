package com.hansreygaert.switchfully.euder.service;

import com.hansreygaert.switchfully.euder.domain.entity.Customer;
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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
	private final CustomerRepository customerRepository;
	private final SecurityService securityService;
	private final CustomerMapper customerMapper;
	private final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	public CustomerService(CustomerRepository customerRepository,
								  CustomerMapper customerMapper,
	                       SecurityService securityService) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
		this.securityService = securityService;
	}

	public IdentificationDto register(CustomerRegistrationDto registrationField){
		if (! isRegistrationFieldComplete(registrationField))
			throw new CustomerRegistrationFieldNotCompleteException();
		if(! isUniqueEmail(registrationField.email()))
			throw new CustomerEmailAlreadyExistsException();

		customerRepository.addCustomer(
				  customerMapper.getCustomerFromDto(registrationField)
		);
		logger.info("New customer added");
		return securityService.getIdentificationToken(registrationField.email());
	}

	private boolean isRegistrationFieldComplete(CustomerRegistrationDto customerRegistrationForm){
		return  customerRegistrationForm.firstName() != null
				  && customerRegistrationForm.lastName() != null
				  && customerRegistrationForm.email() != null
				  && customerRegistrationForm.address() != null
				  && customerRegistrationForm.phoneNumber() != null ;
	}

	private boolean isUniqueEmail(String emailField) {
		return customerRepository.getCustomers().stream()
				  .noneMatch(email -> email.getEmail().equals(emailField));
	}

	public CustomerDto getCustomerInformation(String identificationToken,
	                                          String uuid){
		if (! securityService.isAdmin(identificationToken)) return null;
		return customerMapper.getCustomerDto(customerRepository.getCustomerById(uuid));
	}

	public List<CustomerDtoBasicInformation> getAllCustomers(String identificationToken){
		if (! securityService.isAdmin(identificationToken)) return null;
		return customerRepository.getCustomers().stream()
								 .map(customerMapper::getCustomerDtoBasicInfo)
								 .toList();
	}
}
