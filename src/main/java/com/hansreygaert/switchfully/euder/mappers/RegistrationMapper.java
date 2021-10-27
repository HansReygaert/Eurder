package com.hansreygaert.switchfully.euder.mappers;

import com.hansreygaert.switchfully.euder.domain.entity.Customer;
import com.hansreygaert.switchfully.euder.dtos.RegistrationDto;

public class RegistrationMapper {
	public static Customer getCustomerFromDto(RegistrationDto registrationDto){
		return new Customer(registrationDto.firstName(),
				  registrationDto.lastName(), registrationDto.email(),
				  registrationDto.address(), registrationDto.phoneNumber());
	}
}
