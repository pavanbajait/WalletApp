package com.pbajait.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbajait.app.entity.Customer;
import com.pbajait.app.entity.Wallet;
import com.pbajait.app.exception.NotFoundException;
import com.pbajait.app.exception.UserAlreadyExistWithMobileNumber;
import com.pbajait.app.repository.CustomerDao;
import com.pbajait.app.util.GetCurrentLoginUserSessionDetails;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDAO;
	
	@Autowired
	private GetCurrentLoginUserSessionDetails getCurrentLoginUser;
	
	@Override
	public Customer createCustomer(Customer customer) {

		Optional<Customer> opt = customerDAO.findByMobileNo(customer.getMobileNo());
		
		if(opt.isPresent()) {
			throw new UserAlreadyExistWithMobileNumber("User already exist with this mobile number");
		}
		
		Wallet wallet = new Wallet();
		wallet.setWalletBalance(0.0);
		wallet.setCustomer(customer);
		
		customer.setWallet(wallet);
		
		return  customerDAO.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer, String key) {
		
		Customer customer2 = getCurrentLoginUser.getCurrentCustomer(key);
		
		if(customer2 == null) {
			throw new NotFoundException("No user found.. try login first");
		}
		
		customerDAO.save(customer);
		return customer;
	}

	@Override
	public Customer deleteCustomer(String key) {
		
		Customer customer = getCurrentLoginUser.getCurrentCustomer(key);		
		customerDAO.delete(customer);
		return customer;
	}

	@Override
	public Customer getCustomerDetails(String key) {
		
		Customer customer = getCurrentLoginUser.getCurrentCustomer(key);	
		System.out.println(customer);
		return customer;
	}

}
