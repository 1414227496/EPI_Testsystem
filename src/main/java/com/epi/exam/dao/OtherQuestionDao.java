package com.epi.exam.dao;

import com.epi.exam.entity.OtherQuestion;
import com.epi.exam.entity.SelectQuestion;
import com.epi.exam.entity.SelectiveForQuestion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Mapper
public interface OtherQuestionDao {
	int deleteByPrimaryKey(String id);

	int insert(OtherQuestion record);

	int insertSelective(OtherQuestion record);

	OtherQuestion selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(OtherQuestion record);

	int updateByPrimaryKey(OtherQuestion record);

	/**
	 * 根据难度查看题目
	 *
	 * @return
	 */
	List<OtherQuestion> getOtherByDifficulty(String difficulty);

	/**
	 * 按学院查看
	 *
	 * @param department
	 * @return
	 */
	List<OtherQuestion> getSelectByDepartment(String department);

	/**
	 * 按题目状态查看
	 *
	 * @param state 状态
	 * @return
	 */
	List<OtherQuestion> getSelectByState(String state);

	/**
	 * 按用户查看
	 *
	 * @param userId 用户id
	 * @return
	 */
	List<OtherQuestion> getSelectByUser(String userId);

	/**
	 * 是否考试用题
	 *
	 * @param isExam
	 * @return
	 */
	List<OtherQuestion> getSelectByIsExam(int isExam);

	/**
	 * 根据需要的类别查询
	 *
	 * @param selective 类别
	 * @return
	 */
	List<OtherQuestion> getQuestionSeletive(SelectiveForQuestion selective);
}