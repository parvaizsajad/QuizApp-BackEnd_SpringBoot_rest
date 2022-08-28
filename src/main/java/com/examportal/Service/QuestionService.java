package com.examportal.Service;

import java.util.List;
import java.util.Set;

import com.examportal.Entity.Question;
import com.examportal.Entity.Quiz;

public interface QuestionService {
	
	public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question) throws Exception;
	
	public List<Question> getAllQuestions();
	
	public Question getQuestion(Integer questionId) throws Exception;
	
	public List<Question> getQuestionsOfQuiz(Quiz quiz);

	public void DeleteQuestionById(Integer id) throws Exception;

	public List<Question> getAllQuestionss();

	
	

}
