package com.cg.springbootrestjpa.service;

import java.util.List;

import com.cg.springbootrestjpa.entites.Customer;

public interface ICustomerService {
	Customer add(Customer customer);

	Customer update(Customer customer);

	void delete(Long id);

	Customer findById(Long id);

	List<Customer> findAll();

	List<Customer> findByFirstName(String name);

	List<Customer> findByLastName(String name);

	List<Customer> findByFullName(String firstName, String lastName);

}
