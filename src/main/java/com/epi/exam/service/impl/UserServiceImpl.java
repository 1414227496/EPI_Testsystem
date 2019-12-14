package com.epi.exam.service.impl;

import com.epi.exam.dao.UserDao;
import com.epi.exam.entity.User;
import com.epi.exam.service.PermissionService;
import com.epi.exam.service.RoleService;
import com.epi.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YANGCHAO
 * @create 2019-12-04 9:06
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private RoleService roleService;


	@Override
	public User getUserByTelnumber(String telnumber) {
		return userDao.getUserByTelnumber( telnumber );
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updatePassword(String newPassword, String telnumber) {
		return userDao.updateByTelnumber( newPassword, telnumber );
	}

	@Override
	public User getUserById(String id) {
		return userDao.selectById( id );
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteUserById(String userId) {

		permissionService.deleteAllPermission( userId );
		roleService.deleteRole( userId );
		return userDao.deleteById( userId );
	}

	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public List<User> selectUserByDepartment(String department) {
		return userDao.selectUserByDepartment( department );
	}

	@Override
	public List<User> selectUserByJoinBatch(String joinBatch) {
		return userDao.selectUserByJoinBatch( joinBatch );
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateUserInfo(User user) {
		return userDao.updateByPrimaryKeySelective( user );
	}

	@Override
	public List<User> selectUserByEpiDepartment(String epiDepartment) {
		return userDao.selectUserByEpiDepartment( epiDepartment );
	}
}
