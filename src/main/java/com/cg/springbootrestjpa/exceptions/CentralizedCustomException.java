package com.cg.springbootrestjpa.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedCustomException {
	private static final Logger Log = LoggerFactory.getLogger(CentralizedCustomException.class);

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CustomerNotFoundException.class)
	public String handlerCustomerNotFoundException(CustomerNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(InvalidArgumentException.class)
	public String handlerCustomerNotFoundException(InvalidArgumentException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(InvalidFirstNameAndLastNameException.class)
	public String handlerCustomerNotFoundException(InvalidFirstNameAndLastNameException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public String handleAll(Exception e) {
		Log.error("exception caught", e);
		return e.getMessage();
	}

}
