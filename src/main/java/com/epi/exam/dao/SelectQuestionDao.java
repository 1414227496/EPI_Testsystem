package com.epi.exam.dao;

import com.epi.exam.entity.SelectQuestion;
import com.epi.exam.entity.SelectiveForQuestion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Mapper
public interface SelectQuestionDao {
	/**
	 * 删除题目
	 *
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(String id);

	int insert(SelectQuestion record);

	int insertSelective(SelectQuestion record);

	SelectQuestion selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(SelectQuestion record);

	int updateByPrimaryKey(SelectQuestion record);

	/**
	 * 更新题目状态
	 *
	 * @param id    题目id
	 * @param state 题目的状态：审核中、审核通过、未通过
	 * @return
	 */
	int updateState(String id, String state);

	/**
	 * 根据难度查看题目
	 *
	 * @return
	 */
	List<SelectQuestion> getSelectByDifficulty(String difficulty);

	/**
	 * 按学院查看
	 *
	 * @param department
	 * @return
	 */
	List<SelectQuestion> getSelectByDepartment(String department);

	/**
	 * 按题目状态查看
	 *
	 * @param state 状态
	 * @return
	 */
	List<SelectQuestion> getSelectByState(String state);

	/**
	 * 按用户查看
	 *
	 * @param userId 用户id
	 * @return
	 */
	List<SelectQuestion> getSelectByUser(String userId);

	/**
	 * 是否考试用题
	 *
	 * @param isExam
	 * @return
	 */
	List<SelectQuestion> getSelectByIsExam(int isExam);

	/**
	 * 根据需要的类别查询
	 *
	 * @param selective 类别
	 * @return
	 */
	List<SelectQuestion> getQuestionSeletive(SelectiveForQuestion selective);


}