package com.cg.springbootrestjpa.exceptions;

public class InvalidFirstNameAndLastNameException extends RuntimeException {
	public InvalidFirstNameAndLastNameException() {

	}

	public InvalidFirstNameAndLastNameException(String msg) {
		super(msg);
	}

}
