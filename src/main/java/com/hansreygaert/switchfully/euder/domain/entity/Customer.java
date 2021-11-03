package com.hansreygaert.switchfully.euder.domain.entity;

import java.util.Objects;
import java.util.UUID;

public class Customer {

  private final String uuid;
  private final String firstName;
  private final String lastName;
  private final String email;
  private final String address;
  private final String phoneNumber;

  public Customer(String firstName, String lastName,
      String email,
      String address, String phoneNumber) {
    this.uuid = UUID.randomUUID().toString();
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.address = address;
    this.phoneNumber = phoneNumber;
  }

  //FOR TESTING ONLY !
  public Customer(String uuid, String firstName, String lastName,
      String email, String address, String phoneNumber) {
    this.uuid = uuid;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.address = address;
    this.phoneNumber = phoneNumber;
  }

  public String getUuid() {
    return uuid;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getAddress() {
    return address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Customer customer = (Customer) o;
    return uuid.equals(customer.uuid) && email.equals(customer.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, email);
  }
}
