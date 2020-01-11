package com.capgemini.springproject.exception;

public class OrderException extends RuntimeException{
String msg;
	
	public OrderException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
	

}
