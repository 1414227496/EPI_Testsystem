package com.epi.exam.controller;

import com.epi.exam.entity.Examination;
import com.epi.exam.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author YANGCHAO
 * @create 2019-12-02 8:51
 */
@Controller
@RequestMapping("/Examination")
public class ExaminationController {
	@Autowired
	private ExaminationService examinationService;

	@RequestMapping("/details")
	@ResponseBody
	public Examination selectExaminationDetails(String id) {

		return examinationService.selectExamDetailsById( id );


	}
}
