package com.umashankar.service;

import java.util.List;

import com.umashankar.models.Reels;
import com.umashankar.models.User;

public interface ReelService {
	public Reels createReels(Reels reel,User user);
	public List<Reels> findAllReels();
	public List<Reels> findReelsBYUser(Integer Userid) throws Exception; 
	

}
