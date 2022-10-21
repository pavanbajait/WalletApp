package com.pbajait.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbajait.app.entity.Transaction;


public interface TransactionDao extends JpaRepository<Transaction, Integer>{

	public List<Transaction> findAllTransactionsByWalletId(Integer id);
	
}