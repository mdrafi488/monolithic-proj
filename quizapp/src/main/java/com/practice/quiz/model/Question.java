package com.practice.quiz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String categeory;
	private String difflevel;
	private String option1;
	private String option2;
	private String option3;
	private String question_title;
	private String right_answer;
	
	
	
	public Question() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategeory() {
		return categeory;
	}
	public void setCategeory(String categeory) {
		this.categeory = categeory;
	}
	public String getDifflevel() {
		return difflevel;
	}
	public void setDifflevel(String difflevel) {
		this.difflevel = difflevel;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getQuestion_title() {
		return question_title;
	}
	public void setQuestiontitle(String question_title) {
		this.question_title = question_title;
	}
	public String getRightanswer() {
		return right_answer;
	}
	public void setRightanswer(String right_answer) {
		this.right_answer = right_answer;
	}
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", categeory=" + categeory + ", difflevel=" + difflevel + ", option1=" + option1
				+ ", option2=" + option2 + ", option3=" + option3 + ", questiontitle=" + question_title
				+ ", rightanswer=" + right_answer + "]";
	}
	
}
