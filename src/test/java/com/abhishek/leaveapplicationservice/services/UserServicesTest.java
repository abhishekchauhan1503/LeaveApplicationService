package com.abhishek.leaveapplicationservice.services;

import static org.junit.Assert.*;

import org.mockito.*;
import static org.mockito.Mockito.when;
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.abhishek.leaveapplication.dao.UserDAO;
import com.abhishek.leaveapplication.dao.impl.UserDaoImpl;
import com.abhishek.leaveapplication.model.Role;
import com.abhishek.leaveapplication.model.User;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
public class UserServicesTest {

	private static final String MANAGER_USERNAME = "manager";
	private static final String USER_USERNAME = "Abhishek";
	private static final String PASSWORD = "password";
	private static final String MANAGER_ROLE_NAME = "Manager";
	private static final String USER_ROLE_NAME = "User";
	private static final long MANAGER_ID = 1;

	@Resource(name = "userTest")
	private User user;

	@Test
	public void createUser_ValidUser_ReturnsUserId() throws Exception {
		UserDaoImpl userDao = Mockito.mock(UserDaoImpl.class);
		User user = new User();
		Role managerRole = new Role();
		managerRole.setRoleId(1);
		managerRole.setRoleName(MANAGER_ROLE_NAME);
		Role userRole = new Role();
		userRole.setRoleId(2);
		userRole.setRoleName(USER_ROLE_NAME);

		user.setUserName(USER_USERNAME);
		user.setPassword(PASSWORD);
		User manager = new User();
		manager.setPassword(PASSWORD);
		manager.setUserName(MANAGER_USERNAME);
		manager.setRoleType(managerRole);
		user.setManagerId(manager);
		user.setRoleType(userRole);
		
		when(userDao.createUser(user)).thenReturn((long) 1);
		
	}

}
