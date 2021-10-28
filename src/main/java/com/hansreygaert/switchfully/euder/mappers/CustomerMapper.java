package com.hansreygaert.switchfully.euder.mappers;

import com.hansreygaert.switchfully.euder.domain.entity.Customer;
import com.hansreygaert.switchfully.euder.dtos.CustomerDto;
import com.hansreygaert.switchfully.euder.dtos.CustomerDtoBasicInformation;
import com.hansreygaert.switchfully.euder.dtos.CustomerRegistrationDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
	public Customer getCustomerFromDto(CustomerRegistrationDto customerRegistrationDto){
		return new Customer(
				  customerRegistrationDto.firstName(),
				  customerRegistrationDto.lastName(), customerRegistrationDto.email(),
				  customerRegistrationDto.address(), customerRegistrationDto.phoneNumber()
		);
	}

	public CustomerDto getCustomerDto(Customer customer){
		return new CustomerDto(
				  customer.getFirstName(), customer.getLastName(),
				  customer.getEmail(), customer.getAddress(),
				  customer.getPhoneNumber()
		);
	}

		public CustomerDtoBasicInformation getCustomerDtoBasicInfo(Customer customer){
			return new CustomerDtoBasicInformation(
					  customer.getUuid(), customer.getUuid(),
					  customer.getFirstName(), customer.getLastName()
			);
		}
}
