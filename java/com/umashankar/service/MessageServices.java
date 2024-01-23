package com.umashankar.service;

import java.util.List;

import com.umashankar.models.Chat;
import com.umashankar.models.Message;
import com.umashankar.models.User;

public interface MessageServices {
	public Message createMessage(User user,Integer chatId, Message req) throws Exception;
	public List<Message> findChats(Integer chatId) throws Exception;
	
		
	

}
