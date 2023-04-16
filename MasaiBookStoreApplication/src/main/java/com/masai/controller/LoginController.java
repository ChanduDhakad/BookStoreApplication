package com.masai.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.User;
import com.masai.model.User;
import com.masai.repository.UserRepository;
import com.masai.repository.UserRepository;

@RestController
public class LoginController {

	@Autowired
	private UserRepository userRepository;
	
//	@GetMapping("/masaibook/user/login")
//	public ResponseEntity<User> getLoggedInUserDetailsHandler(Authentication auth){
//		
//		
//
//		User user= userRepository.findByMobileNumber(auth.getName()).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
//		
//		 return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
//		
//		
//	}
	
	
	@Autowired
	private UserRepository UserRepository;
	
	@GetMapping("/signIn")
	public ResponseEntity<User> getLoggedInUserDetailsHandler1(Authentication auth){
		
		
		 User User= UserRepository.findByEmail(auth.getName()).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
		
		 return new ResponseEntity<>(User, HttpStatus.ACCEPTED);
		
		
	}
}
