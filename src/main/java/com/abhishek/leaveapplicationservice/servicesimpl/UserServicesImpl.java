package com.abhishek.leaveapplicationservice.servicesimpl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import com.abhishek.leaveapplication.dao.UserDAO;
import com.abhishek.leaveapplication.model.User;
import com.abhishek.leaveapplicationservice.entity.RoleEntity;
import com.abhishek.leaveapplicationservice.entity.UserEntity;
import com.abhishek.leaveapplicationservice.generatedclasses.CreateUserInput;
import com.abhishek.leaveapplicationservice.generatedclasses.GetUserInput;
import com.abhishek.leaveapplicationservice.services.UserServices;
import com.abhishek.leaveapplicationservices.util.EntityAdapter;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private EntityAdapter adapter;

	public long createUser(CreateUserInput userInput) throws Exception {
		if(userInput == null){
			throw new DataRetrievalFailureException(
					"Null Input Provided!!!");
		}
		
		if (userInput.getUserName() == null
				|| userInput.getPassword() == null
				|| userInput.getRoleId() <= 0) {
			throw new DataRetrievalFailureException(
					"ERROR: Username, password and role type are required.");
		}
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(userInput.getUserName());
		userEntity.setPassword(userInput.getPassword());
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setId(userInput.getRoleId());
		userEntity.setRoleType(roleEntity);
		
		if(userInput.getManagerId()>0){
		UserEntity manager = new UserEntity();
		manager.setId(userInput.getManagerId());
		userEntity.setManager(manager);
		}
		
		User user = adapter.userEntityToUser(userEntity);
		long id = userDao.createUser(user);
		return id;
	}

	public UserEntity getUser(GetUserInput userInput) throws Exception {
		if(userInput == null){
			throw new DataRetrievalFailureException(
					"Username or Id is required");
		}
		String userName = userInput.getUserName();
		long id = userInput.getUserId();
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
