package com.examportal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.examportal.Entity.Role;
import com.examportal.Entity.User;
import com.examportal.Entity.UserRole;
import com.examportal.Service.UserService;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner{
	
	@Autowired
	public UserService Userservice;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	/**	User user=new User();
		user.setId(55);
		user.setUsername("gggg");
		user.setFirstname("gggggg");
		user.setLastname("ggggg");
		user.setPassword("gggggg");
		user.setEmail("ggggggg@gmail.com");
		user.setProfiles("gggg.png");
		user.setPhone("8973gggg444433343");
		
		System.out.println(user);
		//Role role=new Role();
		//role.setRoleName("ADMIN");
		
		
		Set<UserRole> userRoleSet=new HashSet<UserRole>();
		
		
	//	UserRole userRole=new UserRole();
	//	userRole.setUser(user);
	//	userRole.setRole(role);
		
		
		
		
		
		
		//userRoleSet.add(userRole);
		
		
		
		
		User createUser = this.Userservice.createUser(user, userRoleSet);
		//System.out.println(createUser.getUsername());
		
	**/

		
	}
	



}
