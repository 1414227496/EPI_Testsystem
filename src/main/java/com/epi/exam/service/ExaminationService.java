package com.epi.exam.service;


import com.epi.exam.entity.Examination;

/**
 * @author YANGCHAO
 * @create 2019-12-02 16:24
 */


public interface ExaminationService {
	Examination selectExamDetailsById(String id);
}
