package com.hansreygaert.switchfully.euder.dtos;

public record CustomerRegistrationDto(
		  String firstName,
		  String lastName,
		  String email,
		  String address,
		  String phoneNumber
) {
}
