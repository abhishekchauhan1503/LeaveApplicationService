package com.abhishek.leaveapplicationservice.services;

import com.abhishek.leaveapplicationservice.entity.RoleEntity;
import com.abhishek.leaveapplicationservice.generatedclasses.CreateRoleInput;
import com.abhishek.leaveapplicationservice.generatedclasses.GetRoleInput;

public interface RoleServices {
	public long createRole(CreateRoleInput roleInput) throws Exception;
	public RoleEntity getRole(GetRoleInput roleInput) throws Exception;
}
