package com.epi.exam.controller;

import com.epi.exam.entity.Permission;
import com.epi.exam.service.PermissionList;
import com.epi.exam.service.PermissionService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author YANGCHAO
 * @create 2019-12-09 16:07
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	PermissionService permissionService;

	@Autowired
	PermissionList permissionList;

	/**
	 * 删除某个用户的某个权限
	 *
	 * @param userId
	 * @param permission
	 * @return
	 */
	@RequiresRoles(value = {"admin", "adjustAdmin"}, logical = Logical.OR)
	@RequiresPermissions(value = {"delete"})
	@RequestMapping("deletePermission")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	public int deletePermissionByUserId(String userId, String permission) {
		if (userId != null && permission != null) {
			return permissionService.deletePermission( userId, permission );
		}
		return 0;
	}

	@RequiresRoles(value = {"admin", "adjustAdmin"}, logical = Logical.OR)
	@RequiresPermissions(value = {"insert"})
	@RequestMapping("insertPermission")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	public int insertPermissionByUserId(String userId, String permission) {
		String roleId = permissionService.getRoleIdByUserId( userId );
		List<Permission> permissionLists = permissionService.getPermissionListById( roleId );
		//查询当前用户是否拥有该权限
		for (Permission p : permissionLists) {
			if (p.equals( permission )) {
				return 0;
			}
		}
		//插入权限
		if ("insert".equals( permission )) {

			return permissionList.insertPermission( roleId );
		}
		if ("select".equals( permission )) {

			return permissionList.selectPermission( roleId );
		}
		if ("update".equals( permission )) {

			return permissionList.updatePermission( roleId );
		}
		if ("delete".equals( permission )) {

			return permissionList.deletePermission( roleId );
		}
		return 0;
	}


}
