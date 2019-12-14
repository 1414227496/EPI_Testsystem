package com.epi.exam.entity;

import java.util.Date;

public class Examination {
	private String id;

	private String headline;

	private Date beginTime;

	private String department;

	private String remark;

	private String state;

	private String questionType;

	private Integer number;

	private Date endtime;

	private Integer averageScore;

	private String extraQuestion;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline == null ? null : headline.trim();
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department == null ? null : department.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType == null ? null : questionType.trim();
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Integer getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(Integer averageScore) {
		this.averageScore = averageScore;
	}

	public String getExtraQuestion() {
		return extraQuestion;
	}

	public void setExtraQuestion(String extraQuestion) {
		this.extraQuestion = extraQuestion == null ? null : extraQuestion.trim();
	}
}