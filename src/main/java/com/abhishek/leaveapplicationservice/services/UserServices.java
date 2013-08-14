package com.abhishek.leaveapplicationservice.services;

import com.abhishek.leaveapplication.model.User;

public interface UserServices {

	public long createUser(User user) throws Exception;

	public User getUser(String userName, long id) throws Exception;

}
