package com.arasan.authservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arasan.authservice.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	boolean existsByUsername(String username);

	@Query(value =  "SELECT u FROM User u WHERE u.username = ?1 and u.password = ?2")
	User authenticate(String username,String password);

	@Transactional
	void deleteByUsername(String username);
	
	User findByUsername(String username);
}
