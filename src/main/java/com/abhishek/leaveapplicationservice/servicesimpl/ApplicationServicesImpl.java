package com.abhishek.leaveapplicationservice.servicesimpl;

import javax.annotation.Resource;

import org.springframework.dao.DataRetrievalFailureException;

import com.abhishek.leaveapplication.dao.ApplicationDAO;
import com.abhishek.leaveapplication.model.Application;

public class ApplicationServicesImpl implements ApplicationDAO {

	private ApplicationDAO applicationDAO;

	public long createNewApplication(Application application) throws Exception {
		if (application.getFrom() == null
				|| application.getTo() == null
				|| application.getSubmissionDate() == null
				|| application.getContent() == null
				|| (application.getStatus() != 'P'
						&& application.getStatus() != 'R' && application
						.getStatus() != 'A')) {
			throw new DataRetrievalFailureException("Missing attributes");
		}
		long id = applicationDAO.createNewApplication(application);
		return id;
	}

	public Application getApplication(long id) throws Exception {
		if (id <= 0) {
			throw new DataRetrievalFailureException(
					"Null or Inalid application Id");
		}
		Application application = applicationDAO.getApplication(id);
		return application;
	}

	public long updateApplication(Application application) throws Exception {
		if (application.getId() <= 0
				|| application.getFrom() == null
				|| application.getTo() == null
				|| application.getSubmissionDate() == null
				|| application.getContent() == null
				|| (application.getStatus() != 'P'
						&& application.getStatus() != 'R' && application
						.getStatus() != 'A'))

		{
			throw new DataRetrievalFailureException("Missing attributes");
		}
		long updateResult = applicationDAO.updateApplication(application);
		return updateResult;
	}

	@Resource(name = "applicationDao")
	public ApplicationDAO getApplicationDAO() {
		return applicationDAO;
	}

	public void setApplicationDAO(ApplicationDAO applicationDAO) {
		this.applicationDAO = applicationDAO;
	}

}
