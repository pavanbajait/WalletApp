package com.pbajait.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transectionId;
	
	
	private LocalDateTime transactionDate;
	
	private double amount;
	
	private String description;
	
	private Integer walletId;

	public Transaction(LocalDateTime transactionDate, double amount,
			String description) {
		super();
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.description = description;
	}


}
