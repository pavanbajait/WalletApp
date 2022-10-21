package com.pbajait.app.service;

import com.pbajait.app.entity.CustomerDTO;

public interface CustomerLogin {
	
	public String logIntoAccount(CustomerDTO customerDTO);
	
	public String logOutFromAccount(String key);

}