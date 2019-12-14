package com.epi.exam.service;

import com.epi.exam.entity.Role;

import java.util.List;

/**
 * @author YANGCHAO
 * @create 2019-12-04 9:01
 */
public interface RoleService {
	List<Role> findByUserId(String id);

	String insertRole(String userId);

	int updateRole(String userId, String role);

	String selectIdByUserId(String userId);

	int deleteRole(String userId);
}
