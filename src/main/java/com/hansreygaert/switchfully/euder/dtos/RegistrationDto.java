package com.hansreygaert.switchfully.euder.dtos;

public record RegistrationDto(
		  String firstName,
		  String lastName,
		  String email,
		  String address,
		  String phoneNumber
) {
}
