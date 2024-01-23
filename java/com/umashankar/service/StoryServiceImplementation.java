package com.umashankar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umashankar.models.Story;
import com.umashankar.models.User;
import com.umashankar.repository.StoryRepository;

@Service
public class StoryServiceImplementation implements StoryService{
	@Autowired
	StoryRepository storyRepo;
	@Autowired
	UserServices us;

	@Override
	public Story createStory(Story story,User user) throws Exception {
		
		Story createdStory = new Story();
		createdStory.setCaption(story.getCaption());
		createdStory.setId(story.getId());
		createdStory.setImage(story.getImage());
		createdStory.setUser(user);
		createdStory.setTimeStamp(story.getTimeStamp());
		storyRepo.save(createdStory);
		
		return createdStory;
	}

	@Override
	public List<Story> findStoryByUserid(Integer userid) {
		
		return storyRepo.findByUserId(userid);
	}

}
