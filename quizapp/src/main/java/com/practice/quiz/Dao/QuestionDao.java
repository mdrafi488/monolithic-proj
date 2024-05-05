package com.practice.quiz.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.quiz.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

	List<Question> findBycategeory(String categeory);
	
	@Query(value = "SELECT * FROM question q Where q.categeory=:categeory ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
	List<Question> findRandomQusetionsByCategeory(String categeory, Integer numQ);
	

}
