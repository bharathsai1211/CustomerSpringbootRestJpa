package com.cg.springbootrestjpa.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AddCustomer {
	@NotBlank
	@Size(min = 2, max = 20)
	private String firstName;
	@NotBlank
	@Size(min = 2, max = 20)
	private String LastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

}
