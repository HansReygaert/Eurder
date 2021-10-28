package com.hansreygaert.switchfully.euder.controllers;

import com.hansreygaert.switchfully.euder.dtos.IdentificationDto;
import com.hansreygaert.switchfully.euder.dtos.RegistrationDto;
import com.hansreygaert.switchfully.euder.service.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/register")
public class RegisterController {
	private final RegisterService registerService;

	public RegisterController(RegisterService registerService){
		this.registerService = registerService;
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public IdentificationDto register(RegistrationDto registrationDto){
		return registerService.register(registrationDto);
	}

	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public IdentificationDto register(@RequestHeader(required = false) String token){
		if(token != null){
			//TODO: Make it so the user is created now and redirect to '/' with
			// the header included
			return new IdentificationDto(token);
		}
		return null;
	}

}
