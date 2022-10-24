package com.pbajait.app.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbajait.app.entity.CurrentUserSession;
import com.pbajait.app.entity.Customer;
import com.pbajait.app.entity.CustomerDTO;
import com.pbajait.app.exception.InvalidPasswordException;
import com.pbajait.app.exception.NotFoundException;
import com.pbajait.app.exception.UserAlreadyExistWithMobileNumber;
import com.pbajait.app.repository.CustomerDao;
import com.pbajait.app.repository.SessionDao;
import com.pbajait.app.util.GetCurrentLoginUserSessionDetails;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomerLogInImpl implements CustomerLogin{

	@Autowired
	private CustomerDao customerDAO;
	
	@Autowired
	private SessionDao sessionDAO;
	
	@Autowired
	private GetCurrentLoginUserSessionDetails getCurrentLoginUser;
	
	@Override
	public String logIntoAccount(CustomerDTO customerDTO) throws NotFoundException{
		
		Optional<Customer> opt = customerDAO.findByMobileNo(customerDTO.getMobileNo());
		Customer newCustomer = opt.get();
		
		Integer customerId = newCustomer.getCustomerId();
		
		Optional<CurrentUserSession> currentUserOptional = sessionDAO.findByCustomerId(customerId);
		
		if(!opt.isPresent()) {
			throw new NotFoundException("Please Enter Valid Mobile Number");
		}
		
		Customer newCust = opt.get();
		Integer custId = newCust.getCustomerId();
		Optional<CurrentUserSession> currentUserOpt = sessionDAO.findByCustomerId(custId);
		
		if(currentUserOpt.isPresent()) {
			throw new UserAlreadyExistWithMobileNumber("User already logged in with this number");
		}
		
		if(newCustomer.getPassword().equals(customerDTO.getPassword())) {
			
			String key = RandomString.make(6);
			
			CurrentUserSession currentUserSession = new CurrentUserSession(newCustomer.getCustomerId(), key, LocalDateTime.now());			
			sessionDAO.save(currentUserSession);

			return currentUserSession.toString();
		}
		else {
			throw new InvalidPasswordException("Please Enter Valid Password");
		}
	}

	@Override
	public String logOutFromAccount(String key) {
		
		Optional<CurrentUserSession> currentUserOptional = sessionDAO.findByUuid(key);
		
		if(!currentUserOptional.isPresent()) {
			throw new NotFoundException("User is not logged in with this number");
		}
		
		CurrentUserSession currentUserSession = getCurrentLoginUser.getCurrentUserSession(key);
		sessionDAO.delete(currentUserSession);
		
		return "Logged Out...";
	}

}
