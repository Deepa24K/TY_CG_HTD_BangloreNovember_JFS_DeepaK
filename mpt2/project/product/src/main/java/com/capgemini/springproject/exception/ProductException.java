package com.capgemini.springproject.exception;

public class ProductException extends RuntimeException {
	
	String msg;
	
	public ProductException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
	

}
