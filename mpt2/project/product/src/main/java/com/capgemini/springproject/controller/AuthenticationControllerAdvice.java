package com.capgemini.springproject.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.springproject.dto.AuthenticationResponse;
import com.capgemini.springproject.exception.ProductException;

@RestControllerAdvice
public class AuthenticationControllerAdvice {
	
	@ExceptionHandler(ProductException.class)
	public AuthenticationResponse authException(ProductException e) {
		AuthenticationResponse response = new AuthenticationResponse();
		response.setStatusCode(501);
		response.setDescription("Exception");
		response.setMessage(e.getMessage());
		return response;
	}

}
