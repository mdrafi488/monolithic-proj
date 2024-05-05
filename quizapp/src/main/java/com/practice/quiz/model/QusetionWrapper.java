package com.practice.quiz.model;

public class QusetionWrapper {
	
	private Integer id;
	private String question_title;
	private String option1;
	private String option2;
	private String option3;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestion_title() {
		return question_title;
	}
	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
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
	
	public QusetionWrapper(Integer id, String question_title, String option1, String option2, String option3) {
		super();
		this.id = id;
		this.question_title = question_title;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
	}
	
	@Override
	public String toString() {
		return "QusetionWrapper [id=" + id + ", question_title=" + question_title + ", option1=" + option1
				+ ", option2=" + option2 + ", option3=" + option3 + "]";
	}
	

}
