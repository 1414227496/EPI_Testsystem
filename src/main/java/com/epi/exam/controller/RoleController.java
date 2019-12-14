package com.epi.exam.controller;

import com.epi.exam.entity.Role;
import com.epi.exam.service.PermissionList;
import com.epi.exam.service.RoleService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author YANGCHAO
 * @create 2019-12-08 20:14
 */
@Controller
@RequestMapping("roleController")
@Transactional(rollbackFor = Exception.class)
public class RoleController {
	private static final String admin = "admin";
	private static final String normalUser = "user";
	private static final String addUser = "normalUser";
	private static final String adjustlUser = "adjustAdmin";
	@Autowired
	RoleService roleService;
	@Autowired
	PermissionList permissionList;

	@RequiresRoles(value = {admin, adjustlUser}, logical = Logical.OR)
	@RequestMapping("updateRole")
	@ResponseBody

	public int updateRole(String userId, String role) {
		for (Role role1 : roleService.findByUserId( userId )) {
			//低级别管理员不能注册为高级管理员
			if (role1.equals( adjustlUser ) && role.equals( admin )) {
				return 0;
			}
		}
		//给管理员用户添加删除的权限
		if (role.equals( admin ) || role.equals( adjustlUser )) {
			String roId = roleService.selectIdByUserId( userId );
			permissionList.deletePermission( roId );
		}
		return roleService.updateRole( userId, role );
	}


}
