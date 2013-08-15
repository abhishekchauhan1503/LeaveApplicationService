package com.abhishek.leaveapplicationservice.services;

import com.abhishek.leaveapplication.model.User;
import com.abhishek.leaveapplicationservice.entity.UserEntity;
import com.abhishek.leaveapplicationservice.generatedclasses.CreateUserInput;
import com.abhishek.leaveapplicationservice.generatedclasses.GetUserInput;

public interface UserServices {

	public long createUser(CreateUserInput userInput) throws Exception;

	public UserEntity getUser(GetUserInput userInput) throws Exception;

}
