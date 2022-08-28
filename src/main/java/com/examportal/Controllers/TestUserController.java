package com.examportal.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.Entity.TestUser;
import com.examportal.Repository.testUserRepo;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
public class TestUserController {
	@Autowired
	private testUserRepo repo;
	
	@PostMapping("/test")
	public TestUser saveTest(@RequestBody TestUser testUser) {
		testUser.setName("binod");
		System.out.println(testUser);
		return this.repo.save(testUser);
	}
}
