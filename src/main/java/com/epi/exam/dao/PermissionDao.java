package com.epi.exam.dao;

import com.epi.exam.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao {
	int deleteByPrimaryKey(String id);

	int insert(Permission record);

	int insertSelective(Permission record);

	Permission selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Permission record);

	int updateByPrimaryKey(Permission record);

	List<Permission> getPermissionListById(String roleId);

	int deleteBySelective(String userId, String permission);

	String getIdByUserId(String userId);
}