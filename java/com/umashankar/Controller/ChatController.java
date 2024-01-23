package com.umashankar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.umashankar.Request.CreateChatRequest;
import com.umashankar.models.Chat;
import com.umashankar.models.User;
import com.umashankar.service.ChatService;
import com.umashankar.service.UserServices;

@RestController
public class ChatController {
	@Autowired
	private ChatService chatService;
	@Autowired
	private UserServices us;
	@PostMapping("/api/chats")
	public Chat createChat(@RequestHeader("Authorization") String jwt,@RequestBody CreateChatRequest req) throws Exception {
		User reqUser = us.findUserByJwt(jwt);
		User user2= us.findByid(req.getUserId());
		Chat chat = chatService.createChat(reqUser,user2);
		
		return chat;
		
	}
	@GetMapping("/api/chats")
	public List<Chat> findUsersChat(@RequestBody CreateChatRequest req,@RequestHeader("Authorization") String jwt) {
		User user = us.findUserByJwt(jwt);
		 return  chatService.findChatByUserId(user.getId());
		
		
		
	}
	

}
