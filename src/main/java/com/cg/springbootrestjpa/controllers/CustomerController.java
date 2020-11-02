package com.cg.springbootrestjpa.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.springbootrestjpa.dto.AddCustomer;
import com.cg.springbootrestjpa.dto.CustomerDetails;
import com.cg.springbootrestjpa.entites.Customer;
import com.cg.springbootrestjpa.service.ICustomerService;
import com.cg.springbootrestjpa.util.CustomerUtil;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {
	@Autowired
	private ICustomerService service;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public AddCustomer add(@RequestBody @Valid AddCustomer addCustomer) {
		Customer customer = new Customer();
		customer.setFirstName(addCustomer.getFirstName());
		customer.setLastName(addCustomer.getLastName());
		service.add(customer);
		return addCustomer;
	}

	@PutMapping("/update")
	public CustomerDetails update(@RequestBody @Valid CustomerDetails updateCustomer) {
		Customer customer = new Customer();
		customer.setId(updateCustomer.getId());
		customer.setFirstName(updateCustomer.getFirstName());
		customer.setLastName(updateCustomer.getLastName());
		service.update(customer);
		return updateCustomer;
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		service.delete(id);
		return "deleted with id " + id;
	}

	@GetMapping("/by/id/{id}")
	public CustomerDetails findById(@PathVariable("id") Long id) {
		Customer customer = service.findById(id);
		CustomerDetails customerDetails = CustomerUtil.todetails(customer);
		return customerDetails;
	}

	@GetMapping("/by/firstName/{firstName}")
	public List<CustomerDetails> findByFirstName(
			@PathVariable("firstName") @NotBlank @Size(min = 2, max = 10) String firstName) {
		List<Customer> customers = service.findByFirstName(firstName);
		List<CustomerDetails> customerDetails = CustomerUtil.todetails(customers);
		return customerDetails;
	}

	@GetMapping("/by/lastName/{lastName}")
	public List<CustomerDetails> findByLastName(@PathVariable("lastName") String lastName) {
		List<Customer> customers = service.findByLastName(lastName);
		List<CustomerDetails> customerDetails = CustomerUtil.todetails(customers);
		return customerDetails;
	}

	@GetMapping("/by/fullName/{firstName}/{lastName}")
	public List<CustomerDetails> findByLastName(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		List<Customer> customers = service.findByFullName(firstName, lastName);
		List<CustomerDetails> customerDetails = CustomerUtil.todetails(customers);
		return customerDetails;
	}

	@GetMapping
	public List<CustomerDetails> fetchAll() {
		List<Customer> customers = service.findAll();
		List<CustomerDetails> customerDetails = CustomerUtil.todetails(customers);
		return customerDetails;
	}

}
