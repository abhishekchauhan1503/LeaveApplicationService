package com.abhishek.leaveapplicationservice.entity;

public class UserEntity {

	private long id;
	private String userName;
	private String password;
	private RoleEntity roleType;
	private UserEntity manager;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleEntity getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleEntity roleType) {
		this.roleType = roleType;
	}

	public UserEntity getManager() {
		return manager;
	}

	public void setManager(UserEntity manager) {
		this.manager = manager;
	}

}
