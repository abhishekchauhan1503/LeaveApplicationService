package com.abhishek.leaveapplicationservice.servicesimpl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.test.context.ContextConfiguration;

import com.abhishek.leaveapplication.dao.UserDAO;
import com.abhishek.leaveapplication.model.User;
import com.abhishek.leaveapplicationservice.services.UserServices;

@ContextConfiguration(locations = { "classpath:/META-INF/spring/service-context.xml" })
public class UserServicesImpl implements UserServices {

	private UserDAO userDao;
	
	public long createUser(User user) throws Exception {
		
		if (user == null || user.getUserName() == null
				|| user.getPassword() == null || user.getRoleType() == null) {
			throw new DataRetrievalFailureException(
					"ERROR: Username, password and role type are required.");
		}
		long id = userDao.createUser(user);
		return id;
	}

	public User getUser(String userName, long id) throws Exception {
		if (userName == null && id == 0) {
			throw new DataRetrievalFailureException(
					"Username or Id is required");
		}
		User user = userDao.getUser(userName, id);
		return user;
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	@Resource(name="userDao")
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	
}
