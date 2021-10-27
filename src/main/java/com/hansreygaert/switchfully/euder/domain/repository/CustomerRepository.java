package com.hansreygaert.switchfully.euder.domain.repository;

import com.hansreygaert.switchfully.euder.domain.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CustomerRepository {
	private final Map<String, Customer> customers;

	public CustomerRepository() {
		customers = new HashMap<>();
	}

	public List<Customer> getCustomers(){
		return customers.values().stream().toList();
	}

	public void addCustomer(Customer customer){
		customers.put(customer.getUuid(),customer);
	}
}
