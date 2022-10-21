package com.pbajait.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbajait.app.entity.Customer;


public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	public Optional<Customer> findByMobileNo(String mobileNo);
	
}
