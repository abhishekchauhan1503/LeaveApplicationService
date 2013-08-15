package com.abhishek.leaveapplicationservice.servicesimpl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import com.abhishek.leaveapplication.dao.UserDAO;
import com.abhishek.leaveapplication.model.User;
import com.abhishek.leaveapplicationservice.entity.UserEntity;
import com.abhishek.leaveapplicationservice.services.UserServices;
import com.abhishek.leaveapplicationservice.utils.EntityAdapter;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private EntityAdapter adapter;

	public long createUser(UserEntity userEntity) throws Exception {

		if (userEntity == null || userEntity.getUserName() == null
				|| userEntity.getPassword() == null
				|| userEntity.getRoleType() == null) {
			throw new DataRetrievalFailureException(
					"ERROR: Username, password and role type are required.");
		}
		User user = adapter.userEntityToUser(userEntity);
		long id = userDao.createUser(user);
		return id;
	}

	public UserEntity getUser(String userName, long id) throws Exception {
		if (userName == null && id == 0) {
			throw new DataRetrievalFailureException(
					"Username or Id is required");
		}
		User user = userDao.getUser(userName, id);
		UserEntity userEntity = adapter.userToEntity(user);
		return userEntity;
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public EntityAdapter getAdapter() {
		return adapter;
	}

	public void setAdapter(EntityAdapter adapter) {
		this.adapter = adapter;
	}

}
