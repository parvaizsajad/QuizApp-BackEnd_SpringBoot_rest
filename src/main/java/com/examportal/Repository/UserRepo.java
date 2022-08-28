package com.examportal.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.Entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{

	Optional<User> findByUsername(String username);

}
