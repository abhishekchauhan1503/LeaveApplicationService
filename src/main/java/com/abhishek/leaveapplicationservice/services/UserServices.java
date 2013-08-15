package com.abhishek.leaveapplicationservice.services;

import com.abhishek.leaveapplication.model.User;
import com.abhishek.leaveapplicationservice.entity.UserEntity;

public interface UserServices {

	public long createUser(UserEntity user) throws Exception;

	public UserEntity getUser(String userName, long id) throws Exception;

}
