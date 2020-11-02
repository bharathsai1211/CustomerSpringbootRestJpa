package com.cg.springbootrestjpa.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CustomerDetails {
	private Long id;
	@NotBlank
	@Size(min = 2, max = 20)
	private String firstName;
	@NotBlank
	@Size(min = 2, max = 20)
	private String lastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
