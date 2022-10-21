package com.pbajait.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbajait.app.entity.Wallet;

public interface WalletDao extends JpaRepository<Wallet, Integer>{

}
