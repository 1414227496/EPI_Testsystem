package com.epi.exam.service.impl;

import com.epi.exam.dao.UserDao;
import com.epi.exam.entity.User;
import com.epi.exam.service.RegistService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YANGCHAO
 * @create 2019-12-04 11:15
 */
@Service
public class RegistServiceImpl implements RegistService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int regist(User user) {
		String md5Hash = new Md5Hash( user.getPassword(), "xiaoqing", 1 ).toString();
		user.setPassword( md5Hash );
		return userDao.insert( user );
	}
}
