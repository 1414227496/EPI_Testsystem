package com.epi.exam.service.impl;

import com.epi.exam.dao.PermissionDao;
import com.epi.exam.entity.Permission;
import com.epi.exam.service.PermissionList;
import com.epi.exam.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YANGCHAO
 * @create 2019-12-08 15:06
 */
@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	PermissionDao permissionDao;
	@Autowired
	PermissionList permissionList;


	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deletePermission(String userId, String permission) {
		return permissionDao.deleteBySelective( userId, permission );

	}

	@Override
	public List<Permission> getPermissionListById(String roleId) {
		return permissionDao.getPermissionListById( roleId );
	}

	@Override
	public String getRoleIdByUserId(String userId) {
		return permissionDao.getIdByUserId( userId );
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteAllPermission(String userId) {
		return permissionDao.deleteByPrimaryKey( userId );
	}


}
