package com.abhishek.leaveapplicationservice.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.abhishek.leaveapplication.dao.AuthenticationDAO;
import com.abhishek.leaveapplication.model.User;
import com.abhishek.leaveapplicationservice.entity.UserEntity;
import com.abhishek.leaveapplicationservice.generatedclasses.AuthenticateUserInput;
import com.abhishek.leaveapplicationservice.services.AuthenticationService;
import com.abhishek.leaveapplicationservices.util.EntityAdapter;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private AuthenticationDAO authenticationDAO;

	@Autowired
	private EntityAdapter adapter;

	public UserEntity authenticateUserAndReturnProfileIfUserExists(
			AuthenticateUserInput input) throws Exception {
		if (input == null || input.getUserName() == null
				|| input.getPassword() == null) {
			throw new DataRetrievalFailureException(
					"Username and password are required");
		}
		String userName = input.getUserName();
		String password = input.getPassword();
		User userReturned = authenticationDAO
				.authenticateUserAndReturnProfileIfExists(userName, password);
		UserEntity userEntity = adapter.userToEntity(userReturned);
		return userEntity;
	}

}
