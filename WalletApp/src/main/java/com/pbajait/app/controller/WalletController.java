package com.pbajait.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pbajait.app.exception.InsufficientAmountException;
import com.pbajait.app.service.WalletService;


@RestController
public class WalletController {
	
	@Autowired
	private WalletService walletService;
	
	
//	Get the Wallet balance
	@GetMapping("/walletbalance")
	public double showWalletBalance( @RequestParam(required = false) String key) {
		return walletService.showWalletBalance(key);
	}
	
//	Add money to wallet
	@PostMapping("/addMoney/{amount}")
	public String addMoney(@PathVariable("amount") Double amount,@RequestParam String key) {
				
		return walletService.addMoney(amount, key);
		
	}
	
//	Withdraw money from wallet
	@PostMapping("/withdrawMoney/{amount}")
	public String withdrawMoney(@PathVariable("amount") Double amount,@RequestParam String key) throws InsufficientAmountException {
		
		return walletService.withdrawMoneyFromWallet(amount, key);
		
	}
	
	
	
}