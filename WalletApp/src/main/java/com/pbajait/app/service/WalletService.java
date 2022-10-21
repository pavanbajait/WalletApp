package com.pbajait.app.service;

import com.pbajait.app.exception.InsufficientAmountException;

public interface WalletService {

	public double showWalletBalance(String key);

	public String addMoney(Double amount, String key);

	public String withdrawMoneyFromWallet(Double amount, String key) throws InsufficientAmountException;

}
