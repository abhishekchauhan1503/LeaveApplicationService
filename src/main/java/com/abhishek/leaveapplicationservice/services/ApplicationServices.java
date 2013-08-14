package com.abhishek.leaveapplicationservice.services;

import com.abhishek.leaveapplication.model.Application;


public interface ApplicationServices {
	public long createNewApplication(Application application) throws Exception;
	public long updateApplication(Application application) throws Exception;
	public Application getApplication(long id) throws Exception;
}
