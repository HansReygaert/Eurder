package com.hansreygaert.switchfully.euder.controllers;

import com.hansreygaert.switchfully.euder.dtos.CustomerDto;
import com.hansreygaert.switchfully.euder.dtos.CustomerDtoBasicInformation;
import com.hansreygaert.switchfully.euder.dtos.CustomerRegistrationDto;
import com.hansreygaert.switchfully.euder.dtos.IdentificationDto;
import com.hansreygaert.switchfully.euder.service.CustomerService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  //CREATE
  @PostMapping(consumes = "application/json", produces = "application/json")
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public IdentificationDto createCustomer(
      @RequestBody CustomerRegistrationDto customerRegistrationDto) {
    return customerService.register(customerRegistrationDto);
  }

  //READ ALL
  @GetMapping(produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  public List<CustomerDtoBasicInformation> getAllCustomers
  (@RequestHeader(required = false, value = "uuid") String idToken) {
    return customerService.getAllCustomers(idToken);
  }

  //READ ONE
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = "/{customerId}", produces = "application/json")
  public CustomerDto getCustomerInformation  (@RequestHeader(required = false, value = "uuid") String idToken,
      @PathVariable("customerId") String customerId) {

    return customerService.getCustomerInformation(idToken, customerId);
  }
}