package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.masai.model.User;
import com.masai.repository.UserRepository;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		
		

		Optional<User> opt = userRepo.findByEmail(username);

		if (!opt.isPresent())
			throw new BadCredentialsException("No User registerd with this details");
		else {

			User user= opt.get();
			
			if (passwordEncoder.matches(pwd, user.getPassword())) {

		List<GrantedAuthority> authorities = new ArrayList<>();
		

		return new UsernamePasswordAuthenticationToken(username, pwd, authorities);

			} else
				throw new BadCredentialsException("Invalid Password");

		}

	}

	
	@Override
	public boolean supports(Class<?> authentication) {

	return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);

	}

}

