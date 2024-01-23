package com.umashankar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umashankar.models.Chat;
import com.umashankar.models.Message;
import com.umashankar.models.User;
import com.umashankar.repository.MessageRepository;
@Service
public class MessageServiceImplementation implements MessageServices{
	@Autowired
	private MessageRepository messageRepo;
	@Autowired
	private ChatService chatService;
	

	@Override
	public Message createMessage(User user, Integer chatId, Message req) throws Exception {
		Chat chat = chatService.findChatById(chatId);
		Message msg = new Message();
		msg.setChat(chat);
		msg.setContent(req.getContent());
		msg.setImage(req.getImage());
		msg.setTimeStamp(req.getTimeStamp());
		return messageRepo.save(msg);
	}

	@Override
	public List<Message> findChats(Integer chatId) throws Exception {
	Chat chat = chatService.findChatById(chatId);
	 
	
		return messageRepo.findBYChatId(chatId);
	}
}

	