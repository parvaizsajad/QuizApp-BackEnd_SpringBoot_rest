package com.examportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.Entity.TestUser;

public interface testUserRepo extends JpaRepository<TestUser, Integer>{

}
