package com.abhishek.leaveapplicationservice.services;

import com.abhishek.leaveapplication.model.Role;

public interface RoleServices {
	public long createRole(Role roleType) throws Exception;
	public Role getRole(long roleId) throws Exception;
}
