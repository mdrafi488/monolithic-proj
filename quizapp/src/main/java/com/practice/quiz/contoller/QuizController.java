package com.practice.quiz.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.quiz.model.QusetionWrapper;
import com.practice.quiz.model.Response;
import com.practice.quiz.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String categeory, @RequestParam Integer numQ, @RequestParam String title)
	{
		return quizService.createQuiz(categeory,numQ,title);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QusetionWrapper>> getQuizQuestions(@PathVariable Integer id)
	{
		return quizService.getQuizQuestions(id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable int id,@RequestBody List<Response> response)
	{
	
		return quizService.calculateResult(id,response);
	}

}
