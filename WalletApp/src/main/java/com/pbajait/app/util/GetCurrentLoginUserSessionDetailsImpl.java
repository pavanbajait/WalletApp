package com.pbajait.app.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pbajait.app.entity.CurrentUserSession;
import com.pbajait.app.entity.Customer;
import com.pbajait.app.entity.Wallet;
import com.pbajait.app.exception.NotFoundException;
import com.pbajait.app.repository.CustomerDao;
import com.pbajait.app.repository.SessionDao;

@Service
public class GetCurrentLoginUserSessionDetailsImpl implements GetCurrentLoginUserSessionDetails{

	@Autowired
	private SessionDao sessionDAO;

	@Autowired
	private CustomerDao customerDAO;
	
	@Override
	public CurrentUserSession getCurrentUserSession(String key) {
		Optional<CurrentUserSession> optional = sessionDAO.findByUuid(key);
		
		if(!optional.isPresent()) {
			throw new NotFoundException("Unauthorized");
		}
		return optional.get();

	}
	
	@Override
	public Integer getCurrentUserSessionId(String key){
		Optional<CurrentUserSession> optional = sessionDAO.findByUuid(key);
		
		if(!optional.isPresent()) {
			throw new NotFoundException("Unauthorized");
		}
		
		return optional.get().getId();
	}
	
//	@Override
//	public Customer getCurrentCustomer(String key) {
//		Optional<CurrentUserSession> optional = sessionDAO.findByUuid(key);
//		
//		if(!optional.isPresent()) {
//			throw new NotFoundException("Unauthorized");
//		}
//		
//		Integer customerId = optional.get().getCustomerId();
//		
//		return  customerDAO.getById(customerId);
//	}
//	
	@Override
	public Wallet getCurrentUserWallet(String key) {
		Optional<CurrentUserSession> optional = sessionDAO.findByUuid(key);
		
		if(!optional.isPresent()) {
			throw new NotFoundException("Unauthorized");
		}
		
		Integer customerId = optional.get().getCustomerId();
		Customer customer = customerDAO.getById(customerId);
		
		Wallet wallet = customer.getWallet();
		
		return wallet;
	}
	
	
}
