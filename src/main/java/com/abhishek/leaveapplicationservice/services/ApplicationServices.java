package com.abhishek.leaveapplicationservice.services;

import com.abhishek.leaveapplicationservice.entity.ApplicationEntity;


public interface ApplicationServices {
	public long createNewApplication(ApplicationEntity application) throws Exception;
	public long updateApplication(ApplicationEntity application) throws Exception;
	public ApplicationEntity getApplication(long id) throws Exception;
}
