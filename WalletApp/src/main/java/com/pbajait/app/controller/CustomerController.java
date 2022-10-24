package com.pbajait.app.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pbajait.app.entity.Customer;
import com.pbajait.app.service.CustomerService;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerServiceImpl;
	
	// to register user
	@PostMapping(value = "/customer")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {
		Customer cust = customerServiceImpl.createCustomer(customer);
		return new ResponseEntity<Customer>(cust,HttpStatus.CREATED);
	}
	
	// To update existing user details by passing its login key
	@PutMapping(value = "/customer")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer, @RequestParam(required = false) String key) {
		Customer cust =  customerServiceImpl.updateCustomer(customer, key);
		return new ResponseEntity<Customer>(cust,HttpStatus.ACCEPTED);
	}
	
	// To delete existing user details by passing its login key
	@DeleteMapping(value = "/customer")
	public ResponseEntity<String> deleteCustomer(@RequestParam(required = false) String key) {
		Customer cust = customerServiceImpl.deleteCustomer(key);
		if (cust == null) {
			return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Problem in deleting", HttpStatus.BAD_REQUEST);
		}
	}
	
	// To get details of current user by passing its login key
	@GetMapping(value = "/customer")
	public ResponseEntity<Customer> getCustomerDetails(@RequestParam(required = false) String key) {
		Customer cust = customerServiceImpl.getCustomerDetails(key);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
}