package com.berkay.banking_system_project.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.berkay.banking_system_project.models.User;
import com.berkay.banking_system_project.repository.UserRepository;
import com.berkay.banking_system_project.request.EnabledDisabledRequest;
import com.berkay.banking_system_project.request.RegisterRequest;

public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public boolean registerUser(RegisterRequest registerRequest) {
		User user  = User.builder()
				.username(registerRequest.getName())
				.email(registerRequest.getEmail())
				.password(registerRequest.getPassword())
				.build();
		
		return this.userRepository.createUser(user);
	}
	
	public boolean enableDisableUser(boolean enabledDisabled, int id) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		
		map.put("enabledDisabled", enabledDisabled);
		map.put("id", id);

		return this.userRepository.enableDisableUser(map);
	}
}
