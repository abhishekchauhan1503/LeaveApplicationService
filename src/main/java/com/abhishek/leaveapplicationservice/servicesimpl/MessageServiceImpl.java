package com.abhishek.leaveapplicationservice.servicesimpl;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.abhishek.leaveapplication.dao.MessageDAO;
import com.abhishek.leaveapplication.model.Message;
import com.abhishek.leaveapplication.model.User;
import com.abhishek.leaveapplicationservice.generatedclasses.CreateNewMessageInput;
import com.abhishek.leaveapplicationservice.generatedclasses.GetMessagesInput;
import com.abhishek.leaveapplicationservice.services.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDAO messageDao;

	public long saveNewMessage(CreateNewMessageInput message) throws Exception {
		if (message == null) {
			throw new DataRetrievalFailureException("Null input provided");
		}
		if (message.getFrom() <= 0 || message.getTo() <= 0
				|| message.getContent() == null) {
			throw new DataRetrievalFailureException("Missing attributes");
		}
		Message messageToSave = new Message();
		messageToSave.setContent(message.getContent());
		messageToSave.setCreationDate(new Date());
		messageToSave.setRead(false);

		User to = new User();
		User from = new User();
		to.setId(message.getTo());
		from.setId(message.getFrom());
		messageToSave.setTo(to);
		messageToSave.setFrom(from);

		long result = messageDao.saveNewMessage(messageToSave);
		return result;
	}

	public long findNumberOfUnreadMessagesForUser(GetMessagesInput getInput)
			throws Exception {
		if (getInput == null) {
			throw new DataRetrievalFailureException("Null input provided");
		}
		if (getInput.getUserId() <= 0) {
			throw new DataRetrievalFailureException("Invalid UserId provided");
		}

		long result = messageDao.findNumberOfUnreadMessagesForUser(getInput
				.getUserId());
		return result;
	}

	public ArrayList<Message> getAllMessagesForUser(GetMessagesInput getInput)
			throws Exception {
		if (getInput == null) {
			throw new DataRetrievalFailureException("Null input provided");
		}
		if (getInput.getUserId() <= 0) {
			throw new DataRetrievalFailureException("Invalid UserId provided");
		}
		User user = new User();
		user.setId(getInput.getUserId());
		ArrayList<Message> messages = messageDao.getAllMessagesForUser(user);
		return messages;
	}

}
