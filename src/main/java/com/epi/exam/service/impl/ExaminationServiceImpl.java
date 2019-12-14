package com.epi.exam.service.impl;

import com.epi.exam.dao.ExaminationDao;
import com.epi.exam.entity.Examination;
import com.epi.exam.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author YANGCHAO
 * @create 2019-12-02 16:25
 */

@Service
public class ExaminationServiceImpl implements ExaminationService {

	@Autowired
	private ExaminationDao exam;

	@Override
	public Examination selectExamDetailsById(String id) {

		return exam.selectByPrimaryKey( id );
	}
}
