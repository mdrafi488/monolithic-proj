package com.practice.quiz.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.quiz.model.Question;
import com.practice.quiz.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		return questionService.getAllQuestions();
	}
	
	@GetMapping("categeory/{categeory}")
	public ResponseEntity<List<Question>> getQuestions(@PathVariable String categeory)
	{
		return questionService.getQuestions(categeory);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question)
	{
	   return questionService.addQuestion(question);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable Integer id)
	{
		return questionService.deleteQuestion(id);
	}
	
	@PutMapping("update")
	public ResponseEntity<String> updateQuestion(@RequestBody Question question)
	{
		return questionService.updateQuestion(question);
	}

}
