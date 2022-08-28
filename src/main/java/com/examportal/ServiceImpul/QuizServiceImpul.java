package com.examportal.ServiceImpul;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examportal.Entity.Category;
import com.examportal.Entity.Quiz;
import com.examportal.Repository.QuizRepo;
import com.examportal.Service.CategoryService;
import com.examportal.Service.QuizService;
@Service
public class QuizServiceImpul implements QuizService {
	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private CategoryService catService;
	
	@Override
	public Quiz AddQuiz(Quiz quiz) {
		
	return	quizRepo.save(quiz);
	}
	@Override
	public List<Quiz> getByCategory(Integer cId) throws Exception {
		
		Category categoryById = this.catService.getCategoryById(cId);
		
	
		List<Quiz> catQuizes=	this.quizRepo.findByCategory(categoryById);
		List<Quiz> activeQuiz = catQuizes.stream().filter(i->i.isActive()==true).collect(Collectors.toList());
		return activeQuiz;
	}
	

	
	@Override
	public Quiz getQuizById(Integer id) {
		
		
		return quizRepo.findById(id).get();
	}
	@Override
	public Quiz updateQuiz(Quiz quiz) throws Exception {
	Quiz quiz2 = quizRepo.findById(quiz.getqId()).orElseThrow(()-> new Exception("Quiz not found"));
	quiz2.setTitle(quiz.getTitle());
	quiz2.setDescription(quiz.getDescription());
	quiz2.setMaxMarks(quiz.getMaxMarks());
	quiz2.setNumberOfQuestions(quiz.getNumberOfQuestions());
	quiz2.setActive(quiz.isActive());
	quiz2.setCategory(quiz.getCategory());
		return quizRepo.save(quiz2);
	}
	@Override
	public List<Quiz> getAllQuizes() {
		
		List<Quiz> all = quizRepo.findAll();
		List<Quiz> activeQuiz = all.stream().filter(i->i.isActive()==true).collect(Collectors.toList());
		return activeQuiz;
	}
	
	@Transactional
	@Override
	public void DeleteQuiz(Integer id) {

	this.quizRepo.deleteById(id);
		
	}
}
