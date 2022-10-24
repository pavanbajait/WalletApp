package com.pbajait.app.service;

import com.pbajait.app.entity.CustomerDTO;
import com.pbajait.app.exception.NotFoundException;

public interface CustomerLogin {
	
	public String logIntoAccount(CustomerDTO customerDTO) throws NotFoundException;
	
	public String logOutFromAccount(String key);

}