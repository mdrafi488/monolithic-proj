package com.practice.quiz.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.quiz.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {
	
}
