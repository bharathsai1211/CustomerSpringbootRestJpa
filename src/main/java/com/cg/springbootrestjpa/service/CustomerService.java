package com.cg.springbootrestjpa.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springbootrestjpa.dao.ICustomerdao;
import com.cg.springbootrestjpa.entites.Customer;
import com.cg.springbootrestjpa.exceptions.CustomerAlreadyExistsException;
import com.cg.springbootrestjpa.exceptions.CustomerNotFoundException;
import com.cg.springbootrestjpa.util.ValidationUtil;

@Service
@Transactional
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerdao dao;

	@Override
	public Customer add(Customer customer) {
		ValidationUtil.checkArgumentsNotNull(customer);
		ValidationUtil.checkFirstNameAndLastName(customer.getFirstName(), customer.getLastName());
		boolean exists = customer.getId() != null && dao.existsById(customer.getId());
		if (exists) {
			throw new CustomerAlreadyExistsException("customer already exists for id=" + customer.getId());
		}
		return dao.save(customer);
	}

	@Override
	public Customer update(Customer customer) {
		ValidationUtil.checkArgumentsNotNull(customer);
		ValidationUtil.checkFirstNameAndLastName(customer.getFirstName(), customer.getLastName());
		return dao.save(customer);
	}

	@Override
	public void delete(Long id) {
		dao.deleteById(id);

	}

	@Override
	public Customer findById(Long id) {
		Optional<Customer> option = dao.findById(id);
		if (!option.isPresent()) {
			throw new CustomerNotFoundException("customer not found for id=" + id);
		}
		return option.get();
	}

	@Override
	public List<Customer> findAll() {
		return dao.findAll();

	}

	@Override
	public List<Customer> findByFirstName(String name) {

		return dao.findByFirstName(name);
	}

	@Override
	public List<Customer> findByLastName(String name) {

		return dao.findByLastName(name);
	}

	@Override
	public List<Customer> findByFullName(String firstName, String lastName) {

		return dao.findByFirstNameAndLastName(firstName, lastName);
	}

}
