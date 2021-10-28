package com.hansreygaert.switchfully.euder.domain.repository;

import com.hansreygaert.switchfully.euder.domain.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepository {
	private final Map<String, Customer> customers;

	@Autowired
	public CustomerRepository() {
		customers = new HashMap<>();
	}

	public List<Customer> getCustomers(){
		return customers.values().stream().toList();
	}

	public Customer getCustomerById(String uuid){
		return customers.get(uuid);
	}

	public void addCustomer(Customer customer){
		customers.put(customer.getUuid(),customer);
	}
}
