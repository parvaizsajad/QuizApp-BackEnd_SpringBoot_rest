package com.examportal.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.examportal.Entity.User;
import com.examportal.Repository.UserRepo;

@Service
public class UserDetalServiceImpul implements UserDetailsService {

	@Autowired
	private UserRepo userRep;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user = this.userRep.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User name not alvailable with "+username));
	
		return user;
	}

}
