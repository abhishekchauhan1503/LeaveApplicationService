package com.abhishek.leaveapplicationservice.services;

import java.util.ArrayList;


import com.abhishek.leaveapplication.model.Message;
import com.abhishek.leaveapplicationservice.generatedclasses.CreateNewMessageInput;
import com.abhishek.leaveapplicationservice.generatedclasses.GetMessagesInput;

public interface MessageService {
	public long saveNewMessage(CreateNewMessageInput message) throws Exception;
	public long findNumberOfUnreadMessagesForUser(GetMessagesInput getInput) throws Exception;
	public ArrayList<Message> getAllMessagesForUser(GetMessagesInput getInput) throws Exception;
	public long updateMessage(CreateNewMessageInput input) throws Exception;
}
