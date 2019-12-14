package com.epi.exam.service.impl;

import com.epi.exam.dao.RoleDao;
import com.epi.exam.entity.Role;
import com.epi.exam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YANGCHAO
 * @create 2019-12-04 9:06
 */
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> findByUserId(String id) {
		return roleDao.findByUserId( id );
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String insertRole(String userId) {
		Role role = new Role();
		role.setUserId( userId );
		role.setRole( "normalUser" );
		role.setAuthen( "1" );
		roleDao.insertSelective( role );

		return roleDao.findRoleIdByUserId( userId );
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateRole(String userId, String role) {
		return roleDao.updateRole( userId, role );
	}

	@Override
	public String selectIdByUserId(String userId) {
		return roleDao.selectIdByUserId( userId );
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteRole(String userId) {
		return roleDao.deleteByUserId( userId );
	}
}
