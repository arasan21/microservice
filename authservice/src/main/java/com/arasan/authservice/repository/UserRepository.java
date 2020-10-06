package com.arasan.authservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arasan.authservice.model.Customer;

public interface UserRepository extends JpaRepository<Customer, Integer>{

	boolean existsByUsername(String username);

	@Transactional
	void deleteByUsername(String username);
	
	Customer findByUsername(String username);
}
