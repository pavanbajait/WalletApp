package com.pbajait.app.service;

import com.pbajait.app.entity.Customer;
import com.pbajait.app.exception.NotFoundException;

public interface CustomerService {
	public Customer createCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer, String key) throws NotFoundException;
	
	public Customer deleteCustomer(String key) throws NotFoundException;
	
	public Customer getCustomerDetails(String key) throws NotFoundException;
}
