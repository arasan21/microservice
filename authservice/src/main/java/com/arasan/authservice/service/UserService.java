package com.arasan.authservice.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	
	public String authenticate(String username, String password) {
		return "Success";
	}

}
