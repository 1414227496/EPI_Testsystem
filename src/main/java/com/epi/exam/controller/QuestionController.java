package com.epi.exam.controller;

import com.epi.exam.entity.Questions;
import com.epi.exam.entity.SelectQuestion;
import com.epi.exam.entity.SelectiveForQuestion;
import com.epi.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author YANGCHAO
 * @create 2019-12-13 19:23
 */
@RequestMapping("/questions")
@Controller
@Transactional(rollbackFor = Exception.class)
public class QuestionController {
	@Autowired
	QuestionService questionService;


	/**
	 * 按类别查询题目
	 *
	 * @param selectiveForQuestion
	 * @return
	 */
	@RequestMapping("/getQuestionBySeletive")
	@ResponseBody
	public Questions getQuestionBySeletive(SelectiveForQuestion selectiveForQuestion) {

		return questionService.getQuestionBySeletive( selectiveForQuestion );

	}

	/**
	 * 查看用户添加的题目
	 *
	 * @param userId
	 * @return
	 */
	@RequestMapping("/getQuestionByUser")
	@ResponseBody
	public Questions getQuestionByUser(String userId) {
		if (userId == null) {
			return null;
		}
		return questionService.getQuestionByUser( userId );
	}

	@RequestMapping("/insertQuestion")
	@ResponseBody
	public int insertQuestion(String userId) {
		if (userId == null) {
			return 1;
		}
		return 0;
	}


}
