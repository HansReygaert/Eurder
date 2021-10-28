package com.hansreygaert.switchfully.euder.controllers;

import com.hansreygaert.switchfully.euder.dtos.CustomerDto;
import com.hansreygaert.switchfully.euder.dtos.CustomerDtoBasicInformation;
import com.hansreygaert.switchfully.euder.dtos.IdentificationDto;
import com.hansreygaert.switchfully.euder.dtos.CustomerRegistrationDto;
import com.hansreygaert.switchfully.euder.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService){
		this.customerService = customerService;
	}
	//CREATE
	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public IdentificationDto getAllCustomers(CustomerRegistrationDto customerRegistrationDto){
		return customerService.register(customerRegistrationDto);
	}
	//READ ALL
	@GetMapping(produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<CustomerDtoBasicInformation> getAllCustomers
	(@RequestHeader(required = false, value = "uuid") String idToken){
		return customerService.getAllCustomers(idToken);
	}
	//READ ONE
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/{customerId}", produces = "application/json")
	public CustomerDto getCustomerInformation
	(@RequestHeader(required = false, value = "uuid") String idToken,
	 @PathVariable("customerId") String customerId){

		return customerService.getCustomerInformation(idToken,customerId);
	}
}