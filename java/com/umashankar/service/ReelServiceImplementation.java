 package com.umashankar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umashankar.models.Reels;
import com.umashankar.models.User;
import com.umashankar.repository.ReelsRepository;
@Service
public class ReelServiceImplementation implements ReelService{
	@Autowired
	private ReelsRepository reelRepo;
	@Autowired
	private UserServices us;
	

	@Override
	public Reels createReels(Reels reel,User user) {
		Reels createReel = new Reels();
		createReel.setTittle(reel.getTittle());
		createReel.setUser(reel.getUser());
		createReel.setVideo(reel.getVideo());
		reelRepo.save(createReel);
		return null;
	}

	@Override
	public List<Reels> findAllReels() {
		
		return reelRepo.findAll();
	}

	@Override
	public List<Reels> findReelsBYUser(Integer Userid) throws Exception {
		us.findByid(Userid);
		return reelRepo.findByUserId(Userid);
	}

}
