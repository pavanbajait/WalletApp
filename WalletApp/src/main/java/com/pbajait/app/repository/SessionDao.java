package com.pbajait.app.repository;

import java.util.Optional;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pbajait.app.entity.CurrentUserSession;



@Repository
public interface SessionDao extends JpaRepository<CurrentUserSession, Id>{
	
	public Optional<CurrentUserSession> findByCustomerId(Integer customerId);
	
	public Optional<CurrentUserSession> findByUuid(String uuid);
}
