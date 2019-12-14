package com.epi.exam.service.impl;

import com.epi.exam.dao.OtherQuestionDao;
import com.epi.exam.dao.SelectQuestionDao;
import com.epi.exam.entity.OtherQuestion;
import com.epi.exam.entity.Questions;
import com.epi.exam.entity.SelectQuestion;
import com.epi.exam.entity.SelectiveForQuestion;
import com.epi.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YANGCHAO
 * @create 2019-12-13 15:47
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	SelectQuestionDao selectQuestionDao;
	@Autowired
	OtherQuestionDao otherQuestionDao;

	@Override
	public int insertSelectQuestion(SelectQuestion question) {
		return selectQuestionDao.insert( question );
	}

	@Override
	public int insertOtherQuestion(OtherQuestion question) {
		return otherQuestionDao.insert( question );
	}

	@Override
	public int updateSelectQuestion(SelectQuestion question) {
		return selectQuestionDao.updateByPrimaryKey( question );
	}

	@Override
	public int updateOtherQuestion(OtherQuestion question) {
		return otherQuestionDao.updateByPrimaryKey( question );
	}

	@Override
	public int deleteSelectQuestion(String id) {
		return selectQuestionDao.deleteByPrimaryKey( id );
	}

	@Override
	public int deleteOtherQuestion(String id) {
		return otherQuestionDao.deleteByPrimaryKey( id );
	}


	@Override
	public Questions getQuestionByUser(String userId) {
		Questions questions = new Questions();
		questions.setSelectQuestions( selectQuestionDao.getSelectByUser( userId ) );
		questions.setOtherQuestions( otherQuestionDao.getSelectByUser( userId ) );
		return questions;
	}


	@Override
	public Questions getQuestionBySeletive(SelectiveForQuestion selective) {
		Questions questions = new Questions();
		if (selective.getQuestionType().contains( "选择题" )) {
			questions.setSelectQuestions( selectQuestionDao.getQuestionSeletive( selective ) );
		}
		questions.setOtherQuestions( otherQuestionDao.getQuestionSeletive( selective ) );
		System.out.println( questions.toString() );
		return questions;
	}
}
