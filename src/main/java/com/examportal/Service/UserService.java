package com.examportal.Service;

import java.util.List;
import java.util.Set;

import com.examportal.Entity.User;
import com.examportal.Entity.UserRole;

public interface UserService {

	//create user
	
	public User createUser(User dto, Set<UserRole> userRoleDtos) throws Exception;

	public List<User> getUsers();

	public User getUsersByUsername(String username) throws Exception;

	public String DeleteUserById(Integer userId) throws Exception;

	public User UpdateUserById(Integer userId,User user) throws Exception;
}
