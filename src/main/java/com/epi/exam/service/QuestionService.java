package com.epi.exam.service;

import com.epi.exam.entity.OtherQuestion;
import com.epi.exam.entity.Questions;
import com.epi.exam.entity.SelectQuestion;
import com.epi.exam.entity.SelectiveForQuestion;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YANGCHAO
 * @create 2019-12-13 14:42
 */
@Service
public interface QuestionService {
	/**
	 * 添加选择题
	 *
	 * @param question 题目内容
	 * @return
	 */
	int insertSelectQuestion(SelectQuestion question);

	/**
	 * 添加其他题型
	 *
	 * @param question 题目内容
	 * @return
	 */
	int insertOtherQuestion(OtherQuestion question);

	/**
	 * 更新题目
	 *
	 * @param question 需要更改的内容
	 * @return
	 */
	int updateSelectQuestion(SelectQuestion question);

	int updateOtherQuestion(OtherQuestion question);

	/**
	 * 根据id删除题目
	 *
	 * @param id id
	 * @return
	 */
	int deleteSelectQuestion(String id);

	int deleteOtherQuestion(String id);


	/**
	 * 按用户查看
	 *
	 * @param userId 用户id
	 * @return
	 */
	Questions getQuestionByUser(String userId);


	Questions getQuestionBySeletive(SelectiveForQuestion selective);

}
