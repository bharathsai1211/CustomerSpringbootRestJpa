package com.cg.springbootrestjpa.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException {
	public CustomerAlreadyExistsException() {

	}

	public CustomerAlreadyExistsException(String msg) {
		super(msg);
	}

}
