package com.cg.springbootrestjpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.springbootrestjpa.entites.Customer;

public interface ICustomerdao extends JpaRepository<Customer, Long> {

	List<Customer> findByFirstName(String name);

	List<Customer> findByLastName(String name);

	List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

}
