package com.epi.exam.entity;

import lombok.ToString;

import java.util.List;

/**
 * @author YANGCHAO
 * @create 2019-12-13 15:01
 */
@ToString
public class SelectiveForQuestion {
	private List<String> questionType;
	private String difficulty;
	private String department;
	private String personId;
	private int forExam;

	public List<String> getQuestionType() {
		return questionType;
	}

	public void setQuestionType(List<String> questionType) {
		this.questionType = questionType;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}


	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	public int getForExam() {
		return forExam;
	}

	public void setForExam(int forExam) {
		this.forExam = forExam;
	}


}
