package com.abhishek.leaveapplicationservice.services;

import java.util.ArrayList;


import com.abhishek.leaveapplicationservice.entity.ApplicationEntity;
import com.abhishek.leaveapplicationservice.generatedclasses.CreateApplicationInput;
import com.abhishek.leaveapplicationservice.generatedclasses.GetApplicationForUserInput;
import com.abhishek.leaveapplicationservice.generatedclasses.GetApplicationInput;
import com.abhishek.leaveapplicationservice.generatedclasses.UpdateApplicationInput;


public interface ApplicationServices {
	public long createNewApplication(CreateApplicationInput applicationInput) throws Exception;
	public long updateApplication(UpdateApplicationInput applicationInput) throws Exception;
	public ApplicationEntity getApplication(GetApplicationInput applicationInput) throws Exception;
	public ArrayList<ApplicationEntity> getAllApplicationsForUser(GetApplicationForUserInput getApplicationForUserInput) throws Exception;
	public ArrayList<ApplicationEntity> getAllPendingApplicationsForUser(GetApplicationForUserInput getApplicationForUserInput) throws Exception;
}
