package com.abhishek.leaveapplicationservice.servicesimpl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.abhishek.leaveapplication.dao.ApplicationDAO;
import com.abhishek.leaveapplication.model.Application;
import com.abhishek.leaveapplication.model.User;
import com.abhishek.leaveapplicationservice.entity.ApplicationEntity;
import com.abhishek.leaveapplicationservice.generatedclasses.CreateApplicationInput;
import com.abhishek.leaveapplicationservice.generatedclasses.GetApplicationInput;
import com.abhishek.leaveapplicationservice.generatedclasses.UpdateApplicationInput;
import com.abhishek.leaveapplicationservice.services.ApplicationServices;
import com.abhishek.leaveapplicationservice.utils.EntityAdapter;

@Service
public class ApplicationServicesImpl implements ApplicationServices {

	@Autowired
	private ApplicationDAO applicationDAO;

	@Autowired
	private EntityAdapter adapter;

	public ApplicationEntity getApplication(GetApplicationInput applicationInput)
			throws Exception {
		long id;
		if (applicationInput == null) {
			throw new DataRetrievalFailureException("Null application Id");
		}
		id = applicationInput.getApplicationId();
		if (id <= 0) {
			throw new DataRetrievalFailureException("Inalid application Id");
		}
		Application application = applicationDAO.getApplication(id);
		ApplicationEntity applicationEntity = adapter
				.applicationToEntity(application);
		return applicationEntity;
	}

	public long createNewApplication(CreateApplicationInput applicationInput)
			throws Exception {
		// TODO Auto-generated method stub
		if (applicationInput == null) {
			throw new DataRetrievalFailureException("Null input provided");
		}

		if (applicationInput.getFrom() <= 0 || applicationInput.getTo() <= 0
				|| applicationInput.getSubmissionDate() == null
				|| applicationInput.getContent() == null
				|| !(applicationInput.getStatus().equalsIgnoreCase("P"))
				&& !(applicationInput.getStatus().equalsIgnoreCase("R"))
				&& !(applicationInput.getStatus().equalsIgnoreCase("A"))) {
			throw new DataRetrievalFailureException("Missing attributes");
		}

		Application application = new Application();
		application.setContent(applicationInput.getContent());
		application.setStatus(applicationInput.getStatus().charAt(0));
		application.setSubmissionDate(applicationInput.getSubmissionDate());
		User to = new User();
		User from = new User();
		to.setId(applicationInput.getTo());
		from.setId(applicationInput.getFrom());

		application.setTo(to);
		application.setFrom(from);

		// .applicationEntityToApplication(applicationEntity);
		long id = applicationDAO.createNewApplication(application);
		return id;

	}

	public long updateApplication(UpdateApplicationInput applicationInput)
			throws Exception {

		if (applicationInput == null) {
			throw new DataRetrievalFailureException("Null input provided");
		}

		if (applicationInput.getId() <= 0 || applicationInput.getFrom() <= 0
				|| applicationInput.getTo() <= 0
				|| applicationInput.getSubmissionDate() == null
				|| applicationInput.getContent() == null
				|| !(applicationInput.getStatus().equalsIgnoreCase("P"))
				&& !(applicationInput.getStatus().equalsIgnoreCase("R"))
				&& !(applicationInput.getStatus().equalsIgnoreCase("A"))) {
			throw new DataRetrievalFailureException("Missing attributes");
		}
		
		Application application = new Application();
		application.setId(applicationInput.getId());
		application.setContent(applicationInput.getContent());
		application.setStatus(applicationInput.getStatus().charAt(0));
		application.setSubmissionDate(applicationInput.getSubmissionDate());
		User to = new User();
		User from = new User();
		to.setId(applicationInput.getTo());
		from.setId(applicationInput.getFrom());

		application.setTo(to);
		application.setFrom(from);

		long updateResult = applicationDAO.updateApplication(application);
		return updateResult;
	}

	public ApplicationDAO getApplicationDAO() {
		return applicationDAO;
	}

	public void setApplicationDAO(ApplicationDAO applicationDAO) {
		this.applicationDAO = applicationDAO;
	}

	public EntityAdapter getAdapter() {
		return adapter;
	}

	public void setAdapter(EntityAdapter adapter) {
		this.adapter = adapter;
	}

}
