package com.abhishek.leaveapplicationservice.servicesimpl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.abhishek.leaveapplication.dao.ApplicationDAO;
import com.abhishek.leaveapplication.model.Application;
import com.abhishek.leaveapplicationservice.entity.ApplicationEntity;
import com.abhishek.leaveapplicationservice.services.ApplicationServices;
import com.abhishek.leaveapplicationservice.utils.EntityAdapter;

@Service
public class ApplicationServicesImpl implements ApplicationServices {

	@Autowired
	private ApplicationDAO applicationDAO;

	@Autowired
	private EntityAdapter adapter;

	public ApplicationEntity getApplication(long id) throws Exception {
		if (id <= 0) {
			throw new DataRetrievalFailureException(
					"Null or Inalid application Id");
		}
		Application application = applicationDAO.getApplication(id);
		ApplicationEntity applicationEntity = adapter
				.applicationToEntity(application);
		return applicationEntity;
	}

	public long createNewApplication(ApplicationEntity applicationEntity)
			throws Exception {
		// TODO Auto-generated method stub
		if (applicationEntity.getFrom() == null
				|| applicationEntity.getTo() == null
				|| applicationEntity.getSubmissionDate() == null
				|| applicationEntity.getContent() == null
				|| (applicationEntity.getStatus() != 'P'
						&& applicationEntity.getStatus() != 'R' && applicationEntity
						.getStatus() != 'A')) {
			throw new DataRetrievalFailureException("Missing attributes");
		}
		Application application = adapter
				.applicationEntityToApplication(applicationEntity);
		long id = applicationDAO.createNewApplication(application);
		return id;

	}

	public long updateApplication(ApplicationEntity applicationEntity)
			throws Exception {
		if (applicationEntity.getId() <= 0
				|| applicationEntity.getFrom() == null
				|| applicationEntity.getTo() == null
				|| applicationEntity.getSubmissionDate() == null
				|| applicationEntity.getContent() == null
				|| (applicationEntity.getStatus() != 'P'
						&& applicationEntity.getStatus() != 'R' && applicationEntity
						.getStatus() != 'A'))

		{
			throw new DataRetrievalFailureException("Missing attributes");
		}
		Application application = adapter
				.applicationEntityToApplication(applicationEntity);
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
