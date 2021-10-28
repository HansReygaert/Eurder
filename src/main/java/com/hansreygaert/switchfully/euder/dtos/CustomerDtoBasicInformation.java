package com.hansreygaert.switchfully.euder.dtos;

import java.util.Objects;

public final class CustomerDtoBasicInformation {
	private final String uuid;
	private final String email;
	private final String firstName;
	private final String lastName;

	public CustomerDtoBasicInformation(
			  String uuid, String email, String firstName, String lastName
	) {
		this.uuid = uuid;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String uuid() {return uuid;}

	public String email() {return email;}

	public String firstName() {return firstName;}

	public String lastName() {return lastName;}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		var that = ( CustomerDtoBasicInformation ) obj;
		return Objects.equals(this.uuid, that.uuid) &&
				  Objects.equals(this.email, that.email) &&
				  Objects.equals(this.firstName, that.firstName) &&
				  Objects.equals(this.lastName, that.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, email, firstName, lastName);
	}

	@Override
	public String toString() {
		return "CustomerDtoBasicInformation[" +
				  "uuid=" + uuid + ", " +
				  "email=" + email + ", " +
				  "firstName=" + firstName + ", " +
				  "lastName=" + lastName + ']';
	}
}
