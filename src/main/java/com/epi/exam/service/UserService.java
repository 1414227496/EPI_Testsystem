package com.epi.exam.service;

import com.epi.exam.entity.User;

import java.util.List;

/**
 * @author YANGCHAO
 * @create 2019-12-04 9:01
 */
public interface UserService {
	User getUserByTelnumber(String telnumber);

	int updatePassword(String newPassword, String telnumber);

	User getUserById(String id);


	int deleteUserById(String id);

	List<User> selectAll();

	List<User> selectUserByDepartment(String department);

	List<User> selectUserByJoinBatch(String joinBatch);

	int updateUserInfo(User user);


	List<User> selectUserByEpiDepartment(String epiDepartment);
}
