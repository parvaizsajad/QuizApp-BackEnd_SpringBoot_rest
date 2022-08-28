package com.examportal.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examportal.Entity.Category;
import com.examportal.Entity.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {
	
	Optional<Quiz> findByTitle(String title);
	@Modifying
	@Query(value = "delete from Quiz q where q.qId=:qesid")
	void deleteQuiz(@Param("qesid")Integer id);
	List<Quiz> findByCategory(Category categoryById);

}
