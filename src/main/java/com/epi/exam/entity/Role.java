package com.epi.exam.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

import java.util.List;

public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	private String userId;

	private String role;

	private String authen;
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
	private List<Permission> permissionList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role == null ? null : role.trim();
	}

	public String getAuthen() {
		return authen;
	}

	public void setAuthen(String authen) {
		this.authen = authen == null ? null : authen.trim();
	}

	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}