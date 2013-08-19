package com.abhishek.leaveapplicationservice.services;

import com.abhishek.leaveapplicationservice.entity.UserEntity;
import com.abhishek.leaveapplicationservice.generatedclasses.AuthenticateUserInput;

public interface AuthenticationService {
public UserEntity authenticateUserAndReturnProfileIfUserExists(AuthenticateUserInput input) throws Exception;
}
