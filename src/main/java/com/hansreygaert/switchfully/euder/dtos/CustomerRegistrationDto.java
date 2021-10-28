package com.hansreygaert.switchfully.euder.dtos;

import java.util.Objects;

public final class CustomerRegistrationDto {
	private final String firstName;
	private final String lastName;
	private final String email;
	private final String address;
	private final String phoneNumber;

	public CustomerRegistrationDto(
			  String firstName,
			  String lastName,
			  String email,
			  String address,
			  String phoneNumber
	) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String firstName() {return firstName;}

	public String lastName() {return lastName;}

	public String email() {return email;}

	public String address() {return address;}

	public String phoneNumber() {return phoneNumber;}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		var that = ( CustomerRegistrationDto ) obj;
		return Objects.equals(this.firstName, that.firstName) &&
				  Objects.equals(this.lastName, that.lastName) &&
				  Objects.equals(this.email, that.email) &&
				  Objects.equals(this.address, that.address) &&
				  Objects.equals(this.phoneNumber, that.phoneNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, email, address, phoneNumber);
	}

	@Override
	public String toString() {
		return "CustomerRegistrationDto[" +
				  "firstName=" + firstName + ", " +
				  "lastName=" + lastName + ", " +
				  "email=" + email + ", " +
				  "address=" + address + ", " +
				  "phoneNumber=" + phoneNumber + ']';
	}

}
