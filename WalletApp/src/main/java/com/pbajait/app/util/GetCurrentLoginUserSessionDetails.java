package com.pbajait.app.util;

import com.pbajait.app.entity.CurrentUserSession;
import com.pbajait.app.entity.Customer;
import com.pbajait.app.entity.Wallet;
import com.pbajait.app.exception.NotFoundException;

public interface GetCurrentLoginUserSessionDetails {

	public CurrentUserSession getCurrentUserSession(String key) throws NotFoundException;
	
	public Integer getCurrentUserSessionId(String key) throws NotFoundException;
	
//	public Customer getCurrentCustomer(String key) throws NotFoundException;
	
	public Wallet getCurrentUserWallet(String key) throws NotFoundException;
	
}