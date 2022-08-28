package com.examportal.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.Entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

	Optional<Category> findByTitle(String title);

}
