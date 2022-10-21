package com.pbajait.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbajait.app.entity.Transaction;
import com.pbajait.app.entity.Wallet;
import com.pbajait.app.exception.NotFoundException;
import com.pbajait.app.repository.TransactionDao;
import com.pbajait.app.repository.WalletDao;
import com.pbajait.app.util.GetCurrentLoginUserSessionDetails;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionDao dao;

	@Autowired
	private GetCurrentLoginUserSessionDetails currentsessiondao;
	
	@Override
	public List<Transaction> getAllTransaction(String key) throws NotFoundException{
		
		Wallet wallet = currentsessiondao.getCurrentUserWallet(key);
		
		Integer id = wallet.getWalletId();
		
		List<Transaction> list = dao.findAllTransactionsByWalletId(id);
		
		if(list.size() == 0) {
			throw new NotFoundException("No transactions are there in wallet");
		}
		return list;
	}

}
