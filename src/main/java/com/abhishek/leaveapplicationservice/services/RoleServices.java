package com.abhishek.leaveapplicationservice.services;

import com.abhishek.leaveapplicationservice.entity.RoleEntity;

public interface RoleServices {
	public long createRole(RoleEntity roleType) throws Exception;
	public RoleEntity getRole(long roleId) throws Exception;
}
