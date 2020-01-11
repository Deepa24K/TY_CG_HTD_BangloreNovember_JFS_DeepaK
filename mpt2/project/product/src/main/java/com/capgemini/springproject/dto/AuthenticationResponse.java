package com.capgemini.springproject.dto;

import java.util.List;


public class AuthenticationResponse {

	
	private int statusCode;
	private String message;
	private String description;
	private List<Authentication> account;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Authentication> getAccount() {
		return account;
	}
	public void setAccount(List<Authentication> account) {
		this.account = account;
	}
	
	
	
}
