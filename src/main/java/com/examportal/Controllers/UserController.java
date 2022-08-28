package com.examportal.Controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.Entity.Role;
import com.examportal.Entity.User;
import com.examportal.Entity.UserRole;
import com.examportal.Service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@PostMapping("/user")
	public ResponseEntity<?>  saveUser(@RequestBody User user) throws Exception{
		
		user.setProfiles("default.png");
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		
		
		Role  role=new Role();
		role.setRoleName("NORMAL");
		role.setRoleId(10);
	
		Set<UserRole> userRoleSet=new HashSet<UserRole>();
		
		UserRole userRole=new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		userRoleSet.add(userRole);
		
		
		
		User user2 = this.userservice.createUser(user, userRoleSet);
		System.out.println(user2);
		
		return new ResponseEntity<User>(user2,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/user")
	public ResponseEntity<?>  saveUser() throws Exception{
		
	List<User> user=	this.userservice.getUsers();
		
		return new ResponseEntity<List<User> >(user,HttpStatus.OK);
		
	}
	
	@GetMapping("/user/{username}")
	public ResponseEntity<?>  saveUserByUserName(@PathVariable("username") String username) throws Exception{
		
	User user=	this.userservice.getUsersByUsername(username);
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	
	//Delete User
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<?>  deleteUserById(@PathVariable("userId") Integer userId) throws Exception{
		
String str=	this.userservice.DeleteUserById(userId);
		
		return new ResponseEntity<String>(str,HttpStatus.OK);
		
	}
	
	@PutMapping("/user/{userId}")
	public ResponseEntity<?>  UpdateUserById(@RequestBody User user,@PathVariable("userId") Integer userId) throws Exception{
		
User usersave=	this.userservice.UpdateUserById(userId,user);
		
		return new ResponseEntity<User>(usersave,HttpStatus.OK);
		
	}
}
