package com.examportal.ServiceImpul;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.examportal.Entity.User;
import com.examportal.Entity.UserRole;
import com.examportal.Repository.RoleRepository;
import com.examportal.Repository.UserRepo;
import com.examportal.Service.UserService;
@Service
public class UserServiceImpul implements UserService {
	
	@Autowired
	private UserRepo userrepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	

	
	// creating user
	@Override
	public User createUser(User user, Set<UserRole> userRole) throws Exception {
		

		Optional<User> optional = this.userrepository.findByUsername(user.getUsername());
		User save=null;
		
		
		  if(optional.isPresent()) { throw new
		  Exception("User Already Preasent try with another user"); }else {
		 
		 userRole.forEach(i-> this.roleRepository.save(i.getRole()));
		 
		 user.getUserList().addAll(userRole);
		 
		userRole.forEach(i-> this.roleRepository.save(i.getRole()));
			save = this.userrepository.save(user);
			user.getUserList().addAll(userRole);
			
	}
			userRole.forEach(i-> this.roleRepository.save(i.getRole()));
		return save;
	}


	@Override
	public List<User> getUsers() {
	
		List<User> list = this.userrepository.findAll();
		return list;
	}


	@Override
	public User getUsersByUsername(String username) throws Exception {
		User user =null;
	
			user= this.userrepository.findByUsername(username).get();
			if(user==null) {
				throw new Exception("user not found with username " +username);
			}
	
		return user;
	}


	@Override
	public String DeleteUserById(Integer userId) throws Exception {
		User user = this.userrepository.findById(userId).orElseThrow(()->new Exception("User not present with user id "+userId));
		this.userrepository.delete(user);
		return "User with user_name "+user.getUsername()+" deleted successfully";
	}


	@Override
	public User UpdateUserById(Integer userId,User usernew) throws Exception {
		User user = this.userrepository.findById(userId).orElseThrow(()->new Exception("User not present with user id "+userId));
		user.setFirstname(usernew.getFirstname());
		user.setLastname(usernew.getLastname());
		user.setPhone(usernew.getPhone());
		user.setPassword(this.passwordEncoder.encode(usernew.getPassword()));
		
		User user2 = this.userrepository.save(user);
		return user2;
	}

}
