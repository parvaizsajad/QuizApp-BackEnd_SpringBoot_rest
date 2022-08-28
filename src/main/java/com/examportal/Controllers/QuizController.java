package com.examportal.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.Entity.Quiz;
import com.examportal.Service.QuizService;

@RestController
@CrossOrigin("*")
public class QuizController {

	@Autowired
	private QuizService quizService;
	

	
	@PostMapping("/quiz")
	public ResponseEntity<?> saveQuiz(@RequestBody Quiz quiz){
		Quiz quiz2 = this.quizService.AddQuiz(quiz);
		return new ResponseEntity<Quiz>(quiz2,HttpStatus.CREATED);
	}
	

	@GetMapping("/quiz/{id}")
	public ResponseEntity<?> getQuizById(@PathVariable("id") Integer id){
		Quiz quiz2 = this.quizService.getQuizById(id);
		return new ResponseEntity<Quiz>(quiz2,HttpStatus.OK);
	}
	
	@GetMapping("/quiz/category/{id}")
	public ResponseEntity<?> getQuizByCategory(@PathVariable("id") Integer id) throws Exception{
		List<Quiz> byCategory = this.quizService.getByCategory(id);
		return new ResponseEntity<List<Quiz>>(byCategory,HttpStatus.OK);
	}
	

	@PutMapping("/quiz")
	public ResponseEntity<?> UpdateQuiz(@RequestBody Quiz quiz) throws Exception{
		Quiz quiz2 = this.quizService.updateQuiz(quiz);
		return new ResponseEntity<Quiz>(quiz2,HttpStatus.OK);
	}
	
	@GetMapping("/quiz")
	public ResponseEntity<?> getQuizes(){
		List<Quiz> quizes = this.quizService.getAllQuizes();
		return new ResponseEntity<List<Quiz>>(quizes,HttpStatus.OK);
	}
	
	@DeleteMapping("/quiz/{id}")
	public ResponseEntity<?> DeleteQuiz(@PathVariable("id") Integer id){
		try {
			 this.quizService.DeleteQuiz(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	 
		return new ResponseEntity<>("Quiz deleted",HttpStatus.OK);
	}
	

	
}
