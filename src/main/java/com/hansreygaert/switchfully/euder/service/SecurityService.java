package com.hansreygaert.switchfully.euder.service;

import com.hansreygaert.switchfully.euder.domain.entity.Administrator;
import com.hansreygaert.switchfully.euder.domain.entity.Customer;
import com.hansreygaert.switchfully.euder.domain.repository.AdminRepository;
import com.hansreygaert.switchfully.euder.domain.repository.CustomerRepository;
import com.hansreygaert.switchfully.euder.dtos.IdentificationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

	private Administrator getAdministrator(String secureToken){
		String uuid = getUserIdFromToken(secureToken);
		if(! isAdmin(uuid)) throw new ResponseStatusException(HttpStatus.FORBIDDEN);

		return adminRepository.getAdministratorById(uuid);
	}

	public boolean isAdmin(String secureToken){
		String uuid = getUserIdFromToken(secureToken);
		return adminRepository.getAdministrators().containsKey(uuid);
	}

	public IdentificationDto getIdentificationToken(String email){
		List<Customer> customer =
				  customerRepository.getCustomers().values().stream()
				  .filter(getCustomer -> getCustomer.getEmail().equals(email))
				  .toList();

		if (customer.size() == 0) return null; logger.warn("User does not exist");
		if (customer.size() > MAX_AMOUNT_OF_EMAIL) logger.error(
				  "User with multiple emails, we have data corruption");

		return getSecureToken(customer.get(0).getUuid());
	}

	private String getUserIdFromToken(String secureToken) {
		//TODO: Implement removal of Salt and pepper
		return secureToken;
	}
	private IdentificationDto getSecureToken(String token){
		//TODO: Add Salt and Pepper
		return new IdentificationDto(token);
	}
}
