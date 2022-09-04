package com.berkay.banking_system_project.repository;


import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;


import com.berkay.banking_system_project.models.User;

@Mapper
public interface UserRepository {

	public User getUserByUsername(String username);
	
	public boolean createUser(User user);
	
	public boolean enableDisableUser(HashMap<String, Object> map);
	
}
