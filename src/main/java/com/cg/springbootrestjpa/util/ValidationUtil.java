package com.cg.springbootrestjpa.util;

import com.cg.springbootrestjpa.exceptions.InvalidArgumentException;
import com.cg.springbootrestjpa.exceptions.InvalidFirstNameAndLastNameException;

public class ValidationUtil {
	public static void checkArgumentsNotNull(Object obj) {
		if (obj == null) {
			throw new InvalidArgumentException("Arguments can't be null");
		}
	}

	public static void checkFirstNameAndLastName(String firstName, String lastName) {
		if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty()) {
			throw new InvalidFirstNameAndLastNameException("firstName and lastName should not be null");
		}
	}

}
