package com.epi.exam.entity;

import lombok.ToString;

import java.util.List;

/**
 * @author YANGCHAO
 * @create 2019-12-13 14:55
 */
@ToString
public class Questions {
	private List<OtherQuestion> otherQuestions;
	private List<SelectQuestion> selectQuestions;

	public List<SelectQuestion> getSelectQuestions() {
		return selectQuestions;
	}

	public void setSelectQuestions(List<SelectQuestion> selectQuestions) {
		this.selectQuestions = selectQuestions;
	}

	public List<OtherQuestion> getOtherQuestions() {
		return otherQuestions;
	}

	public void setOtherQuestions(List<OtherQuestion> otherQuestions) {
		this.otherQuestions = otherQuestions;
	}
}
