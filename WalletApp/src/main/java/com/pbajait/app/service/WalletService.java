package com.pbajait.app.service;

public interface WalletService {

	public double showWalletBalance(String key);

	public String addMoney(Double amount, String key);

	public String withdrawMoneyFromWallet(Double amount, String key);

}
