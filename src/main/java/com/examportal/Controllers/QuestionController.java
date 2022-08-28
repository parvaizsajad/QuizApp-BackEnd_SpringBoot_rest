package com.examportal.Controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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

import com.examportal.Entity.Question;
import com.examportal.Entity.Quiz;
import com.examportal.Service.QuestionService;
import com.examportal.Service.QuizService;
import com.examportal.payload.QuizResults;

@RestController
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuizService quizService;

	@PostMapping("/question")
	public ResponseEntity<?> saveQuiz(@RequestBody Question question) {
		question.setImage("user.png");
		Question question2 = this.questionService.addQuestion(question);
		return new ResponseEntity<Question>(question2, HttpStatus.CREATED);
	}

	@PutMapping("/question")
	public ResponseEntity<?> update(@RequestBody Question question) {
		Question question2 = this.questionService.addQuestion(question);
		return new ResponseEntity<Question>(question2, HttpStatus.CREATED);
	}
	// get All question of any quiz

	@GetMapping("/question/quiz/{id}")
	public ResponseEntity<?> getQuizQuestions(@PathVariable("id") Integer id) {
		Quiz quiz = this.quizService.getQuizById(id);
		List<Question> questionList = this.questionService.getQuestionsOfQuiz(quiz);
		
		questionList.forEach((q)->{
			q.setAnswer("");
		});
		

		
		if (questionList.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
			
			List<Question> subList = questionList.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()));
		
			Collections.shuffle(subList);
			return new ResponseEntity<List<Question>>(subList, HttpStatus.OK);
		}else {
		
		Collections.shuffle(questionList);
		return new ResponseEntity<List<Question>>(questionList, HttpStatus.OK);
		}
	}

	@DeleteMapping("/question/{id}")
	public ResponseEntity<?> Delete(@PathVariable("id") Integer id) {

		try {
			this.questionService.DeleteQuestionById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Question Deleted", HttpStatus.OK);
	}

	@GetMapping("/questionById/{id}")
	public ResponseEntity<?> getQuestionById(@PathVariable("id") Integer id) throws Exception {
		Question question = this.questionService.getQuestion(id);
		return new ResponseEntity<Question>(question, HttpStatus.OK);
	}

	@GetMapping("/questions")
	public ResponseEntity<?> allQuestions(@PathVariable("id") Integer id) throws Exception {
		List<Question> questionList = this.questionService.getAllQuestionss();
		return new ResponseEntity<List<Question>>(questionList, HttpStatus.OK);
	}

	@PostMapping("/results")
	public ResponseEntity<?> Results(@RequestBody List<Question> question) throws Exception {

		QuizResults quizResults = new QuizResults();
		int correctAnswer = 0;
		int maxMarks = 0;
		int MarksperQ = 0;
		int marksObtained = 0;
		int attempted = 0;
		int totalQuestions=0;
		Question q = null;
		
		
		for (Question res : question) {
			
			
			System.out.println(res+"  res post");
			q = this.questionService.getQuestion(res.getId());
			System.out.println(q+"  question from server interal");

			if (res.getYourAnswer() != "") {
				attempted += 1;
			}
			
			if (q.getAnswer().equalsIgnoreCase(res.getYourAnswer())) {
				correctAnswer++;
			}
			
				maxMarks = Integer.parseInt(res.getQuiz().getMaxMarks());

				MarksperQ = maxMarks / question.size();
				System.out.println(question.size()+"   question size");
				marksObtained =MarksperQ*correctAnswer;
				totalQuestions = question.size();
				
			
		}
		quizResults.setTotalQuestions(totalQuestions);
		quizResults.setAttempted(attempted);
		quizResults.setTotalMarks(maxMarks);
		quizResults.setObtainedMarks(marksObtained);
		quizResults.setCorrectAnswers(correctAnswer);
	
		System.out.println(quizResults);

		return new ResponseEntity<QuizResults>(quizResults, HttpStatus.CREATED);
	}

}
