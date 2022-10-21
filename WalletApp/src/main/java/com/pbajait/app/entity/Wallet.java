package com.pbajait.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer walletId ;

	private Double walletBalance;
	
	@OneToOne(cascade =  CascadeType.ALL)
	private Customer customer;

	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "walletId", referencedColumnName = "walletId")
	private List<Transaction> transactions;

}
