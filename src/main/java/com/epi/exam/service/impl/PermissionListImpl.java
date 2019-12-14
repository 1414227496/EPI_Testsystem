package com.epi.exam.service.impl;

import com.epi.exam.dao.PermissionDao;
import com.epi.exam.entity.Permission;
import com.epi.exam.service.PermissionList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YANGCHAO
 * @create 2019-12-09 15:08
 */
@Service
public class PermissionListImpl implements PermissionList {
	private static final String insert = "insert";
	private static final String select = "select";
	private static final String update = "update";
	private static final String delete = "delete";
	@Autowired
	PermissionDao permissionDao;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertPermission(String roleId) {
		Permission permission = new Permission();
		permission.setPermission( insert );
		permission.setRoleId( roleId );
		return permissionDao.insert( permission );

	}

	@Override
	public int selectPermission(String roleId) {
		Permission permission = new Permission();
		permission.setPermission( select );
		permission.setRoleId( roleId );
		return permissionDao.insert( permission );
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updatePermission(String roleId) {
		Permission permission = new Permission();
		permission.setPermission( update );
		permission.setRoleId( roleId );
		return permissionDao.insert( permission );
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deletePermission(String roleId) {
		Permission permission = new Permission();
		permission.setPermission( delete );
		permission.setRoleId( roleId );
		return permissionDao.insert( permission );
	}
}
