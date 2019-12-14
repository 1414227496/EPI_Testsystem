package com.epi.exam.entity;

import lombok.ToString;

import java.util.Date;

@ToString
public class OtherQuestion {
	private String id;

	private String question;

	private String questionType;

	private String answer;

	private String difficulty;

	private String department;

	private Integer correctRatio;

	private String state;

	private Date addTime;

	private String personId;

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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer == null ? null : answer.trim();
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty == null ? null : difficulty.trim();
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department == null ? null : department.trim();
	}

	public Integer getCorrectRatio() {
		return correctRatio;
	}

	public void setCorrectRatio(Integer correctRatio) {
		this.correctRatio = correctRatio;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId == null ? null : personId.trim();
	}

	public Integer getForExam() {
		return forExam;
	}

	public void setForExam(Integer forExam) {
		this.forExam = forExam;
	}
}