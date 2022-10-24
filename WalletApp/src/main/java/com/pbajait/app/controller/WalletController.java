package com.pbajait.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> showWalletBalance( @RequestParam(required = false) String key) {
		String res = walletService.showWalletBalance(key);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	
//	Add money to wallet
	@PostMapping("/addMoney/{amount}")
	public ResponseEntity<String> addMoney(@PathVariable("amount") Double amount,@RequestParam String key) {
				
		String res = walletService.addMoney(amount, key);
		
		return new ResponseEntity<String>(res, HttpStatus.OK);
		
	}
	
//	Withdraw money from wallet
	@PostMapping("/withdrawMoney/{amount}")
	public ResponseEntity<String> withdrawMoney(@PathVariable("amount") Double amount,@RequestParam String key) throws InsufficientAmountException {
		
		String res = walletService.withdrawMoneyFromWallet(amount, key);
		
		return new ResponseEntity<String>(res, HttpStatus.OK);
		
	}
	
	
	
}