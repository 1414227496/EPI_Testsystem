package com.epi.exam.entity;


import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@ToString
public class User {
	@Id
	private String id;
	@Column(unique = true)
	private String telnumber;

	private String name;


	private String password;

	private String sex;

	private String department;

	private String whichClass;

	private String email;

	private String epiDepartment;

	private String epiPosition;

	private Date joinTime;

	private String joinBatch;

	private String officeNumber;

	private Date age;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Role> roleList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getTelnumber() {
		return telnumber;
	}

	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber == null ? null : telnumber.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department == null ? null : department.trim();
	}

	public String getWhichClass() {
		return whichClass;
	}

	public void setWhichClass(String whichClass) {
		this.whichClass = whichClass == null ? null : whichClass.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getEpiDepartment() {
		return epiDepartment;
	}

	public void setEpiDepartment(String epiDepartment) {
		this.epiDepartment = epiDepartment == null ? null : epiDepartment.trim();
	}

	public String getEpiPosition() {
		return epiPosition;
	}

	public void setEpiPosition(String epiPosition) {
		this.epiPosition = epiPosition == null ? null : epiPosition.trim();
	}

	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	public String getJoinBatch() {
		return joinBatch;
	}

	public void setJoinBatch(String joinBatch) {
		this.joinBatch = joinBatch == null ? null : joinBatch.trim();
	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber == null ? null : officeNumber.trim();
	}

	public Date getAge() {
		return age;
	}

	public void setAge(Date age) {
		this.age = age;
	}


	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
}