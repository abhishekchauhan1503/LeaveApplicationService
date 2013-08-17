package com.abhishek.leaveapplicationservice.services;

import java.util.ArrayList;


import com.abhishek.leaveapplication.generatedclasses.CreateNewMessageInput;
import com.abhishek.leaveapplication.generatedclasses.GetMessagesInput;
import com.abhishek.leaveapplication.model.Message;

public interface MessageService {
	public long saveNewMessage(CreateNewMessageInput message) throws Exception;
	public long findNumberOfUnreadMessagesForUser(GetMessagesInput getInput) throws Exception;
	public ArrayList<Message> getAllMessagesForUser(GetMessagesInput getInput) throws Exception;
}
