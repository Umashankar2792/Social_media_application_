package com.umashankar.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umashankar.models.Chat;
import com.umashankar.models.User;
import com.umashankar.repository.ChatRepository;
@Service
public class ChatServiceImplementation implements ChatService
{
	@Autowired
	private ChatRepository chatRepo;

	@Override
	public Chat createChat(User reqUser, User user) {
		
		Chat isExist = chatRepo.findChatByUsers(user, reqUser);
		if(isExist!=null) {
			return isExist;
		}
		Chat newChat = new Chat();
         newChat.getUsers().add(user);
         newChat.getUsers().add(reqUser);
         newChat.setTimeStamp(LocalDateTime.now());
         return chatRepo.save(newChat);
         
	}
         

	@Override
	public Chat findChatById(Integer chatId) throws Exception {
		
		 Optional<Chat> opt=chatRepo.findById(chatId);
		 if(opt.isEmpty()) {
			 throw new Exception("no message exist");
		 }
		 return opt.get();
	}

	@Override
	public List<Chat> findChatByUserId(Integer userId) {
		
		return chatRepo.findByUsersId(userId);
	}

}
