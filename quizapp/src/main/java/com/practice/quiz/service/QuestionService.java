package com.practice.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.quiz.Dao.QuestionDao;
import com.practice.quiz.model.Question;


@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questiondao;

	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
		return new ResponseEntity<>(questiondao.findAll(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_GATEWAY);
	}
	
	
	public ResponseEntity<List<Question>> getQuestions(String categeory)
	{
		try {
		return new ResponseEntity<>(questiondao.findBycategeory(categeory),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_GATEWAY);
	}


	public ResponseEntity<String> addQuestion(Question question) {
		
		try {
		questiondao.save(question);
		return new ResponseEntity<>(" Success ",HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(" Not Added ",HttpStatus.BAD_GATEWAY);
	}


	public ResponseEntity<String> deleteQuestion(Integer id) {
		try {
		questiondao.deleteById(id);
		return new ResponseEntity<>( "Question Deleted ",HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(" Not Deleted ", HttpStatus.BAD_GATEWAY);
	}


	public ResponseEntity<String> updateQuestion(Question question) {
		try {
		questiondao.save(question);
		return new ResponseEntity<>("Updated Question",HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(" Not Updated ",HttpStatus.BAD_GATEWAY);
	}
}
