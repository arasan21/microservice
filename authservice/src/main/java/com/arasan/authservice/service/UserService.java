package com.arasan.authservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arasan.authservice.controller.AuthController;
import com.arasan.authservice.model.Customer;
import com.arasan.authservice.repository.UserRepository;

@Service
public class UserService  implements UserDetailsService {
	
	static final Logger log = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	private UserRepository userRepository;
	
//	public String authenticate(String username, String password) {
//		boolean isUserExists =userRepository.existsByUsername(username);
//		log.debug(username +" is exsits : "+isUserExists);
//		if(!isUserExists) {
//			// If user not found. Throw this exception.
//			throw new UsernameNotFoundException("Username: " + username + " not found");
//		}
//		User user =userRepository.authenticate(username,password);
//		if(user==null) {
//			throw new ResourceNotFoundException("Invalid username/password supplied");
//		}
//		log.debug("User :::"+ user);
//	    return "Success";
//		
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// hard coding the users. All passwords must be encoded.
		Customer user = userRepository.findByUsername(username);
		if(user !=  null) {
			// Remember that Spring needs roles to be in this format: "ROLE_" + userRole (i.e. "ROLE_ADMIN")
			// So, we need to set it to that format, so we can verify and compare roles (i.e. hasRole("ADMIN")).
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils
	                	.commaSeparatedStringToAuthorityList("ROLE_");
			
			// The "User" class is provided by Spring and represents a model class for user to be returned by UserDetailsService
			// And used by auth manager to verify and check user authentication.
			return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
		}
		// If user not found. Throw this exception.
		throw new UsernameNotFoundException("Username: " + username + " not found");
	}

}
