package com.epi.exam.controller;

import com.epi.exam.entity.User;
import com.epi.exam.service.UserService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author YANGCHAO
 * @create 2019-12-04 10:01
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 根据账号查看用户信息
	 *
	 * @param telnumber 账号
	 * @return
	 */
	@RequestMapping("/getUserByTelnumber")
	@ResponseBody
	public User getUserByUserName(String telnumber) {
		User user = userService.getUserByTelnumber( telnumber );
		user.setPassword( null );
		return user;

	}

	/**
	 * 根据用户id查看用户信息
	 *
	 * @param id ID
	 * @return
	 */
	@RequestMapping("/getUserById")
	@ResponseBody
	public User getUserById(String id) {
		System.out.println( userService.getUserById( id ).toString() );
		return userService.getUserById( id );

	}

	/**
	 * 删除用户，同时删除用户角色和权限
	 *
	 * @param userId id
	 * @return
	 */

	@RequiresRoles(value = {"admin", "adjustAdmin"}, logical = Logical.OR)
	@RequestMapping("/deleteUser")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	public int deleteUser(String userId) {
		return userService.deleteUserById( userId );

	}

	/**
	 * 查询所有用户信息
	 *
	 * @return
	 */
	@RequestMapping("/selectAllUsers")
	@ResponseBody
	public List<User> selectAll() {
		return userService.selectAll();

	}

	/**
	 * 按department查看用户
	 *
	 * @param department 学院
	 * @return
	 */
	@RequestMapping("/selectUserByDepartment")
	@ResponseBody
	public List<User> selectUserByDepartment(String department) {
		return userService.selectUserByDepartment( department );

	}

	/**
	 * 按department查看用户
	 *
	 * @param epiDepartment 部门
	 * @return
	 */
	@RequestMapping("/selectUserByEpiDepartment")
	@ResponseBody
	public List<User> selectUserByEpiDepartment(String epiDepartment) {
		return userService.selectUserByEpiDepartment( epiDepartment );

	}

	/**
	 * 根据加入批次查看用户
	 *
	 * @param joinBatch 加入的批次
	 * @return
	 */
	@RequestMapping("/selectUserByJoinBatch")
	@ResponseBody
	public List<User> selectUserByJoinBatch(String joinBatch) {
		return userService.selectUserByJoinBatch( joinBatch );
	}

	/**
	 * 更新用户信息
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateUserInfo")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	public int updateUserInfo(User user) {
		return userService.updateUserInfo( user );

	}


}
