package com.umashankar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.umashankar.models.Reels;
import com.umashankar.models.User;
import com.umashankar.service.ReelService;
import com.umashankar.service.UserServices;

@RestController
public class ReelsController {
	@Autowired
	ReelService rs;
	@Autowired
	private UserServices us;
	@PostMapping("/api/reels")
	public Reels createReels(@RequestBody Reels reel,@RequestHeader("Authorization") String jwt) {
		User reqUser = us.findUserByJwt(jwt);
		Reels createdReel = rs.createReels(reel,reqUser);
		
		return createdReel;
		

}
	@GetMapping("/api/reels")
	public List<Reels> findAllReels(){
		return rs.findAllReels();	
		}
	@GetMapping("/api/reels/user/{userid}")
	public List<Reels> findUsersReel(@PathVariable Integer userid) throws Exception{
		
		return rs.findReelsBYUser(userid);	
		} 
}
