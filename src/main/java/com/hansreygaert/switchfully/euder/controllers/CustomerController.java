package com.hansreygaert.switchfully.euder.controllers;

import com.hansreygaert.switchfully.euder.dtos.CustomerDto;
import com.hansreygaert.switchfully.euder.dtos.CustomerDtoBasicInformation;
import com.hansreygaert.switchfully.euder.dtos.IdentificationDto;
import com.hansreygaert.switchfully.euder.dtos.CustomerRegistrationDto;
import com.hansreygaert.switchfully.euder.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService){
		this.customerService = customerService;
	}
	//CREATE ONE
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public IdentificationDto register(CustomerRegistrationDto customerRegistrationDto){
		return customerService.register(customerRegistrationDto);
	}
	//READ ALL
	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerDtoBasicInformation> register(@RequestHeader(required = false) String idToken){
		if(idToken == null) return null;

		return customerService.getAllCustomers(idToken);
	}
	//READ ONE
	@GetMapping(path = "/{customerId}", consumes =
			  MediaType.APPLICATION_JSON_VALUE)
	public CustomerDto getCustomerInformation(@RequestHeader(required = false) String idToken,
	                                          @PathVariable("customerId") String customerId){

		return customerService.getCustomerInformation(idToken,customerId);
	}

}
