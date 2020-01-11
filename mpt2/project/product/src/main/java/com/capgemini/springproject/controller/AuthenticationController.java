package com.capgemini.springproject.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springproject.dto.Authentication;
import com.capgemini.springproject.dto.AuthenticationResponse;
import com.capgemini.springproject.service.ProductService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class AuthenticationController {

	@Autowired
	ProductService service;

	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse register(@RequestBody Authentication account) {
		AuthenticationResponse response = new AuthenticationResponse();
		service.register(account);
		response.setStatusCode(201);
		response.setDescription("Success");
		response.setMessage("Account created");
		return response;
	}

	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse login(@RequestBody Authentication credentials) {
		AuthenticationResponse response = new AuthenticationResponse();
		Authentication account = service.login(credentials);
		if (account != null) {
			response.setStatusCode(201);
			response.setDescription("Success");
			response.setMessage("Logged in");
			response.setAccount(Arrays.asList(account));
		} else {
			response.setStatusCode(405);
			response.setDescription("Failure");
			response.setMessage("Provide valid credentials");
		}
		return response;
	}
}
