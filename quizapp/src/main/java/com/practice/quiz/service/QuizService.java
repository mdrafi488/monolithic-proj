package com.practice.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.quiz.Dao.QuestionDao;
import com.practice.quiz.Dao.QuizDao;
import com.practice.quiz.model.Question;
import com.practice.quiz.model.Quiz;
import com.practice.quiz.model.QusetionWrapper;
import com.practice.quiz.model.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String categeory, Integer numQ, String title) {
		
		List<Question> questions = questionDao.findRandomQusetionsByCategeory(categeory,numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QusetionWrapper>> getQuizQuestions(Integer id) {
		
		Optional<Quiz> quiz = quizDao.findById(id);
		
		List<Question> quizFromdb = quiz.get().getQuestions();
		
		List<QusetionWrapper> quizForUser = new ArrayList<>();
		
		for(Question q : quizFromdb)
		{
			QusetionWrapper qw = new QusetionWrapper(q.getId(), q.getQuestion_title(), q.getOption1(), q.getOption2(), q.getOption3());
			quizForUser.add(qw);
		}
		
		return new ResponseEntity<>(quizForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
		
		Quiz quiz = quizDao.findById(id).get();
		
		List<Question> question = quiz.getQuestions();
		
		int right = 0;
		
		int i = 0;
		
		for(Response response : responses)
		{
			if(response.getResponse().equals(question.get(i).getRightanswer()))
				right++;
			
			i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
	
	
}
