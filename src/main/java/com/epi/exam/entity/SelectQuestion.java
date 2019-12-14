package com.epi.exam.entity;

import lombok.ToString;

import java.util.Date;

@ToString
public class SelectQuestion {
	private String id;

	private String question;

	private String questionType;

	private String a;

	private String b;

	private String c;

	private String d;

	private String answer;

	private Integer difficulty;

	private String department;

	private Long correctRatio;

	private String state;

	private String personId;

	private Date addTime;

	private Integer forExam;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question == null ? null : question.trim();
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType == null ? null : questionType.trim();
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a == null ? null : a.trim();
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b == null ? null : b.trim();
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c == null ? null : c.trim();
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d == null ? null : d.trim();
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer == null ? null : answer.trim();
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department == null ? null : department.trim();
	}

	public Long getCorrectRatio() {
		return correctRatio;
	}

	public void setCorrectRatio(Long correctRatio) {
		this.correctRatio = correctRatio;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId == null ? null : personId.trim();
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Integer getForExam() {
		return forExam;
	}

	public void setForExam(Integer forExam) {
		this.forExam = forExam;
	}
}