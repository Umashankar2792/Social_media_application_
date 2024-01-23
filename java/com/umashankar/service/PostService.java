package com.umashankar.service;

import java.util.List;

import com.umashankar.models.Post;

public interface PostService {
	Post createNewPost(Post post,Integer userid)throws Exception;
	String deletPost(Integer postid,Integer userid) throws Exception;
	List<Post> findPostByUserid(Integer userid);
	Post findPostById(Integer postid) throws Exception;
	List<Post> findAllPost();
	
	Post savedPost(Integer postid,Integer userid) throws Exception;
	Post likePost(Integer postid,Integer userid) throws Exception;

}
