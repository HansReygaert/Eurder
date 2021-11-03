package com.hansreygaert.switchfully.euder.dtos;

import java.util.Objects;

public class CustomerDto {

  private final String firstName;
  private final String lastName;
  private final String email;
  private final String fullAddress;
  private final String phoneNumber;

  public CustomerDto(
      String firstName,
      String lastName,
      String email,
      String fullAddress,
      String phoneNumber
  ) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.fullAddress = fullAddress;
    this.phoneNumber = phoneNumber;
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

  public String getFullAddress() {
    return fullAddress;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }
    var that = (CustomerDto) obj;
    return Objects.equals(this.firstName, that.firstName) &&
        Objects.equals(this.lastName, that.lastName) &&
        Objects.equals(this.email, that.email) &&
        Objects.equals(this.fullAddress, that.fullAddress) &&
        Objects.equals(this.phoneNumber, that.phoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, email, fullAddress,
        phoneNumber);
  }

  @Override
  public String toString() {
    return "CustomerDto[" +
        "firstName=" + firstName + ", " +
        "lastName=" + lastName + ", " +
        "email=" + email + ", " +
        "fullAddress=" + fullAddress + ", " +
        "phoneNumber=" + phoneNumber + ']';
  }
}
