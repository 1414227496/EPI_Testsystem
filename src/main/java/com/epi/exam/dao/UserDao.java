package com.epi.exam.dao;

import com.epi.exam.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
	int deleteByPrimaryKey(@Param("id") String id, @Param("telnumber") String telnumber);

	int deleteById(String id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(@Param("id") String id, @Param("telnumber") String telnumber);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	User getUserByTelnumber(String telnumber);

	int updateByTelnumber(String password, String telnumber);

	User selectById(String id);

	List<User> selectAll();

	/**
	 * 哪个学院
	 */

	List<User> selectUserByDepartment(String department);

	/**
	 * 加入批次
	 */
	List<User> selectUserByJoinBatch(String joinBatch);

	List<User> selectUserByEpiDepartment(String epiDepartment);
}