package com.hansreygaert.switchfully.euder.service;

import com.hansreygaert.switchfully.euder.domain.entity.Administrator;
import com.hansreygaert.switchfully.euder.domain.entity.Customer;
import com.hansreygaert.switchfully.euder.domain.repository.AdminRepository;
import com.hansreygaert.switchfully.euder.domain.repository.CustomerRepository;
import com.hansreygaert.switchfully.euder.dtos.IdentificationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityService {
	private final Logger logger = LoggerFactory.getLogger(SecurityService.class);
	private final AdminRepository adminRepository;
	private final CustomerRepository customerRepository;

	private static final int MAX_AMOUNT_OF_EMAIL = 1;

	@Autowired
	public SecurityService(AdminRepository adminRepository,
	                       CustomerRepository customerRepository) {
		this.adminRepository = adminRepository;
		this.customerRepository = customerRepository;
	}

	private Administrator getAdministrator(String uuid){
		return adminRepository.getAdministratorById(uuid);
	}


	public boolean isAdmin(String uuid){
		if (getAdministrator(uuid) == null) return true;
		return adminRepository.getAdministratorById(uuid) == null;
	}

	public IdentificationDto getIdentificationToken(String email){
		List<Customer> customer =  customerRepository.getCustomers().stream()
				  .filter(getCustomer -> getCustomer.getEmail().equals(email))
				  .toList();

		if (customer.size() == 0) return null;
		if (customer.size() > MAX_AMOUNT_OF_EMAIL) logger.error(
				  "User with multiple emails, we have data corruption");

		return getSecureToken(customer.get(0).getUuid());
	}

	private IdentificationDto getSecureToken(String token){
		//TODO: Add Salt and Pepper
		return new IdentificationDto(token);
	}
}
