package com.pbajait.app.service;

import java.util.List;

import com.pbajait.app.entity.Transaction;
import com.pbajait.app.exception.NotFoundException;

public interface TransactionService {

	public List<Transaction> getAllTransaction(String key) throws NotFoundException;
	
}
