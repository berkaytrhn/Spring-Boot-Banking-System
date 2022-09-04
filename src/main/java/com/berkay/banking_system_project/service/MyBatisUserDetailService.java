package com.berkay.banking_system_project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.berkay.banking_system_project.models.User;
import com.berkay.banking_system_project.repository.UserRepository;
import com.berkay.banking_system_project.request.RegisterRequest;

@Service
public class MyBatisUserDetailService implements UserDetailsService{

	
	
	
	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


		User user = this.userRepository.getUserByUsername(username);
		user.setAuthorities();
		System.out.println("inside mybatis service user: " + user);
		return user;
	}

	
	

}
