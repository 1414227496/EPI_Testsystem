package com.epi.exam.service;

import com.epi.exam.entity.Permission;

import java.util.List;

/**
 * @author YANGCHAO
 * @create 2019-12-08 15:04
 */
public interface PermissionService {
	/**
	 * 删除某个用户的某个权限
	 *
	 * @param userId
	 * @param permission
	 * @return
	 */
	int deletePermission(String userId, String permission);

	List<Permission> getPermissionListById(String roleId);

	String getRoleIdByUserId(String userId);

	int deleteAllPermission(String userId);
}
