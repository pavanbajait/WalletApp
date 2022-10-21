package com.pbajait.app.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbajait.app.entity.Transaction;
import com.pbajait.app.entity.Wallet;
import com.pbajait.app.exception.InsufficientAmountException;
import com.pbajait.app.repository.TransactionDao;
import com.pbajait.app.repository.WalletDao;
import com.pbajait.app.util.GetCurrentLoginUserSessionDetails;

@Service
public class WalletServiceImpl implements WalletService{
	
	@Autowired
	private WalletDao dao;
	
	@Autowired
	private TransactionDao transactionDao;
	
	@Autowired
	private GetCurrentLoginUserSessionDetails currentsessiondao;

	@Override
	public double showWalletBalance(String key) {
		Double balance = currentsessiondao.getCurrentUserWallet(key).getWalletBalance();
		return balance;
	}
	

	@Override
	@Transactional
	public String addMoney(Double amount, String key) {
		
		Wallet wallet = currentsessiondao.getCurrentUserWallet(key);
		
		
		wallet.setWalletBalance(wallet.getWalletBalance() + amount);
		
		
		dao.save(wallet);	
		
		Transaction myTransaction = new Transaction(LocalDateTime.now(), amount, amount+" is credited in your wallet");
		wallet.getTransactions().add(myTransaction);
		
		transactionDao.save(myTransaction);
		
		return amount+" is credited to your wallet";
	}


	@Override
	public String withdrawMoneyFromWallet(Double amount, String key) throws InsufficientAmountException {

		Wallet wallet = currentsessiondao.getCurrentUserWallet(key);
		

		if(wallet.getWalletBalance() < amount) {
			throw new InsufficientAmountException("Insufficient amount in wallet");
		}
				
		
		wallet.setWalletBalance(wallet.getWalletBalance() - amount);
		
		
		dao.save(wallet);	
		
		Transaction myTransaction = new Transaction(LocalDateTime.now(), amount, amount+" is withdrawn from your wallet");
		wallet.getTransactions().add(myTransaction);
		
		transactionDao.save(myTransaction);
		
		return amount+" is withdrawn from your wallet";
	}

}
