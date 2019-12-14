package com.epi.exam.service;

import com.epi.exam.entity.Permission;

/**
 * @author YANGCHAO
 * @create 2019-12-09 15:21
 */
public interface PermissionList {
	int insertPermission(String roleId);

	int selectPermission(String roleId);

	int updatePermission(String roleId);

	int deletePermission(String roleId);
}
