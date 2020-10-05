package com.arasan.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arasan.authservice.exception.ResourceNotFoundException;
import com.arasan.authservice.model.User;
import com.arasan.authservice.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public String authenticate(String username, String password) {
		
		User user =userRepository.authenticate(username,password);
		if(user==null) {
			throw new ResourceNotFoundException("Invalid username/password supplied");
		}
		System.out.println("User :::"+ user);
	    return "Success";
		
	}

}
