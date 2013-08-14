package com.abhishek.leaveapplicationservice.servicesimpl;

import javax.annotation.Resource;

import org.springframework.dao.DataRetrievalFailureException;

import com.abhishek.leaveapplication.dao.RoleDAO;
import com.abhishek.leaveapplication.model.Role;
import com.abhishek.leaveapplicationservice.services.RoleServices;

public class RoleServicesImpl implements RoleServices {

	private RoleDAO roleDao;
	
	public long createRole(Role roleType) throws Exception {
		if (roleType == null) {
			throw new DataRetrievalFailureException("ERROR: Role is required");
		}
		long id = roleDao.createRole(roleType);
		return id;
	}

	public Role getRole(long roleId) throws Exception {
		if (Long.valueOf(roleId) == null) {
			throw new DataRetrievalFailureException(
					"ERROR: Role id is required");
		}
		Role role = roleDao.getRole(roleId);
		return role;
	}

	public RoleDAO getRoleDao() {
		return roleDao;
	}

	@Resource(name="roleDao")
	public void setRoleDao(RoleDAO roleDao) {
		this.roleDao = roleDao;
	}

	
	
}
