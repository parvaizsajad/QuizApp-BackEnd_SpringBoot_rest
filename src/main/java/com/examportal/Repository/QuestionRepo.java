package com.examportal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examportal.Entity.Question;
import com.examportal.Entity.Quiz;

public interface QuestionRepo extends JpaRepository<Question, Integer> {
	
	List<Question> findByQuiz(Quiz quiz);
	
	@Modifying
	@Query(value = "delete from Question q where q.id=:qesid")
	void deleteQuestion(@Param("qesid")Integer id);
}
