package com.umashankar.service;

import java.util.List;

import com.umashankar.models.Chat;
import com.umashankar.models.User;

public interface ChatService {
	public Chat createChat(User reqUser,User user);
	public Chat findChatById(Integer chatId) throws Exception;
	public List<Chat> findChatByUserId(Integer userId);

}
