package com.epi.exam.entity;

import javax.persistence.*;

/**
 * @author YANGCHAO
 * @create 2019-12-07 16:41
 */

public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String permission;
	private String roleId;
	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
