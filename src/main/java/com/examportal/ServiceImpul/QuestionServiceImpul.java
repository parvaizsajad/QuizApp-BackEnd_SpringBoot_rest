package com.examportal.ServiceImpul;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examportal.Entity.Question;
import com.examportal.Entity.Quiz;
import com.examportal.Repository.QuestionRepo;
import com.examportal.Service.QuestionService;
@Service
public class QuestionServiceImpul implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public Question addQuestion(Question question) {
		
		return this.questionRepo.save(question);
	}

	@Override
	public Question updateQuestion(Question question) throws Exception {
		Question question2 = this.getQuestion(question.getId());
		question2.setOption1(question.getOption1());
		question2.setOption2(question.getOption2());
		question2.setOption3(question.getOption3());
		question2.setOption4(question.getOption4());
		return this.questionRepo.save(question2);
	}

	@Override
	public List<Question> getAllQuestions() {
	
		return this.questionRepo.findAll();
	}

	@Override
	public Question getQuestion(Integer questionId) throws Exception {
		
		return this.questionRepo.findById(questionId).orElseThrow(()-> new Exception("Question not found"));
	}

	@Override
	public List<Question> getQuestionsOfQuiz(Quiz quiz) {
	
		return  this.questionRepo.findByQuiz(quiz);
	}

	@Override
	@Transactional
	public void DeleteQuestionById(Integer id) throws Exception {
	this.questionRepo.deleteQuestion(id);
		
	}

	@Override
	public List<Question> getAllQuestionss() {
		// TODO Auto-generated method stub
		return this.questionRepo.findAll();
	}
	

}
