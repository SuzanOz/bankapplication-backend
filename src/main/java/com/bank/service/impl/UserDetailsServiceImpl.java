package com.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bank.model.User;
import com.bank.repository.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepo userRepo; //Will create the object on demand. 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Load User from Database
		//Take username from login page & validate through database, if user is valid than return userDetails object
		//Repository/DAO
		User user = userRepo.findByUsername(username).orElseThrow(() -> 
                    new UsernameNotFoundException("User Not Found with  username  " + username)
    );
    return user;
	}

}
