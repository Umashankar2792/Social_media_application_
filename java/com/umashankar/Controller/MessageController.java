package com.umashankar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.umashankar.models.Message;
import com.umashankar.models.User;
import com.umashankar.service.MessageServices;
import com.umashankar.service.UserServices;

@RestController
public class MessageController {
	@Autowired
	private MessageServices ms;
	@Autowired
	private UserServices us;
	 @PostMapping("/api/messages/chat/{chatid}")
	 public Message createMessage(@RequestBody Message msg,@RequestHeader("Authorization") String jwt,@PathVariable Integer chatid) throws Exception {
		User user = us.findUserByJwt(jwt);
		 Message messge = ms.createMessage(user, chatid, msg);
				 return messge;
		 
	 }
	 
	 @PostMapping("/api/messages/chat/{chatid}")
	 public List<Message> findChatMessages(@RequestHeader("Authorization") String jwt,@PathVariable Integer chatid) throws Exception {
		User user = us.findUserByJwt(jwt);
		 
				 return ms.findChats(chatid);
		 
	 }

}
