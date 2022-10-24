package com.pbajait.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pbajait.app.entity.Transaction;
import com.pbajait.app.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService service;
	
	@GetMapping("/getAllTransactionHistory")
	public ResponseEntity<List<Transaction>> getAllTransactionHistory(@RequestParam String key){
		List<Transaction> list = service.getAllTransaction(key);
		return new ResponseEntity<List<Transaction>>(list,HttpStatus.OK);
	}
	
}
