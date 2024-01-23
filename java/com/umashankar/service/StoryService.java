package com.umashankar.service;

import java.util.List;

import com.umashankar.models.Story;
import com.umashankar.models.User;

public interface StoryService {
	public Story createStory(Story story,User user) throws Exception;
	
	public List<Story> findStoryByUserid(Integer userid);

}
