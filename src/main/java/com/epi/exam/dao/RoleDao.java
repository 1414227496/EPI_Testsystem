package com.epi.exam.dao;

import com.epi.exam.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Mapper
public interface RoleDao {

	int insert(Role record);

	int insertSelective(Role record);

	Role selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);

	List<Role> findByUserId(String userid);

	int updateRole(String userId, String role);

	String findRoleIdByUserId(String userId);

	String selectIdByUserId(String userId);

	int deleteByUserId(String userId);
}