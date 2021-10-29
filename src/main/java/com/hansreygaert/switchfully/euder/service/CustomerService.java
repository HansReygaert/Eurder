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

	//POST
	public IdentificationDto register(CustomerRegistrationDto registrationField){
		//CAN STILL BE OF WRONG TYPE 
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
		return customerRepository.getCustomers().values().stream()
				  .noneMatch(email -> email.getEmail().equals(emailField));
	}
	//GET One
	public CustomerDto getCustomerInformation(String identificationToken,
	                                          String uuid){
		if (! securityService.isAdmin(identificationToken)) return null;
		if (! customerRepository.getCustomers().containsKey(uuid)) return null;
		return customerMapper.getCustomerDto(customerRepository.getCustomerById(uuid));

	}
	// GET ALL
	public List<CustomerDtoBasicInformation> getAllCustomers(String identificationToken){
		if (! securityService.isAdmin(identificationToken)) return null;
		return customerRepository.getCustomers().values().stream()
								 .map(customerMapper::getCustomerDtoBasicInfo)
								 .toList();
	}
}
