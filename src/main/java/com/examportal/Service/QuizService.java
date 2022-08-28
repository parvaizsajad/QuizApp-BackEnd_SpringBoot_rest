package com.examportal.Service;

import java.util.List;

import com.examportal.Entity.Quiz;

public interface QuizService {

public	Quiz AddQuiz(Quiz quiz);
public 	Quiz getQuizById(Integer id);
public Quiz updateQuiz(Quiz quiz) throws Exception;
public List<Quiz> getAllQuizes();
public void DeleteQuiz(Integer id);
List<Quiz> getByCategory(Integer cId) throws Exception;


}
