package com.cg.springbootrestjpa.util;

import java.util.ArrayList;
import java.util.List;

import com.cg.springbootrestjpa.dto.CustomerDetails;
import com.cg.springbootrestjpa.entites.Customer;

public class CustomerUtil {
	public static CustomerDetails todetails(Customer customer) {
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setFirstName(customer.getFirstName());
		customerDetails.setId(customer.getId());
		customerDetails.setLastName(customer.getLastName());
		return customerDetails;
	}

	public static List<CustomerDetails> todetails(List<Customer> customers) {
		List<CustomerDetails> customerDetailsList = new ArrayList<CustomerDetails>();
		for (Customer customer : customers) {
			CustomerDetails customerDetails = new CustomerDetails();
			customerDetails.setFirstName(customer.getFirstName());
			customerDetails.setId(customer.getId());
			customerDetails.setLastName(customer.getLastName());
			customerDetailsList.add(customerDetails);
		}
		return customerDetailsList;
	}
}
