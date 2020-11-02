package com.cg.springbootrestjpa.exceptions;

public class InvalidArgumentException extends RuntimeException {
	public InvalidArgumentException() {

	}

	public InvalidArgumentException(String msg) {
		super(msg);
	}

}
