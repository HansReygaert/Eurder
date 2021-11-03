package com.hansreygaert.switchfully.euder.domain.repository;

import com.hansreygaert.switchfully.euder.domain.entity.Customer;
import com.hansreygaert.switchfully.euder.service.CustomerService;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

  private final Map<String, Customer> customers;
  private final Logger logger = LoggerFactory.getLogger(CustomerService.class);

  public CustomerRepository() {
    customers = new HashMap<>();
    addDummydata();
  }

  public Map<String, Customer> getCustomers() {
    return customers;
  }

  public Customer getCustomerById(String uuid) {
    return customers.get(uuid);
  }

  public void addCustomer(Customer customer) {
    customers.put(customer.getUuid(), customer);
  }

  private void addDummydata() {
    Customer Jose = new Customer(
        "Jose", "Martin", "jose.martin@gmail.com",
        "Verhaeghepark 997c, 3e verdieping, 5819, Viersel, " +
            "Vlaams-Brabant, Belgium",
        "+32478735644"
    );
    Customer Alexis = new Customer("4cdb4bb8-527c-4fcf-8133-85af2850000e",
        "Alexis", "Larson", "alexii99@outlook.com",
        "Seppeplein 814, 2A, 9514, Leupegem, Limburg, Belgium",
        "+32488531244"
    );
    customers.put(Jose.getUuid(), Jose);
    customers.put(Alexis.getUuid(), Alexis);
  }
}
