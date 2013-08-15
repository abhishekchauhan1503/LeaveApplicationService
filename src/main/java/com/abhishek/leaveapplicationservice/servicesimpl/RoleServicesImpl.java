package com.abhishek.leaveapplicationservice.servicesimpl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.abhishek.leaveapplication.dao.RoleDAO;
import com.abhishek.leaveapplication.model.Role;
import com.abhishek.leaveapplicationservice.entity.RoleEntity;
import com.abhishek.leaveapplicationservice.services.RoleServices;
import com.abhishek.leaveapplicationservice.utils.EntityAdapter;

@Service
public class RoleServicesImpl implements RoleServices {

	@Autowired
	private RoleDAO roleDao;

	@Autowired
	private EntityAdapter adapter;

	public long createRole(RoleEntity roleType) throws Exception {
		if (roleType == null) {
			throw new DataRetrievalFailureException("ERROR: Role is required");
		}
		Role role = adapter.roleEntityToRole(roleType);
		long id = roleDao.createRole(role);
		return id;
	}

	public RoleEntity getRole(long roleId) throws Exception {
		if (Long.valueOf(roleId) == null) {
			throw new DataRetrievalFailureException(
					"ERROR: Role id is required");
		}
		Role role = roleDao.getRole(roleId);
		RoleEntity roleEntity = adapter.roleToEntity(role);
		return roleEntity;
	}

	public RoleDAO getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDAO roleDao) {
		this.roleDao = roleDao;
	}

	public EntityAdapter getAdapter() {
		return adapter;
	}

	public void setAdapter(EntityAdapter adapter) {
		this.adapter = adapter;
	}

}
