package com.umashankar.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umashankar.models.Post;
import com.umashankar.models.User;
import com.umashankar.repository.PostRepository;
import com.umashankar.repository.Userreopository;

@Service
public class PostServiceImplementation implements PostService {
	@Autowired
	PostRepository postRepo;
	@Autowired
	UserServices us;
	@Autowired
	Userreopository userRepo;

	@Override
	public Post createNewPost(Post post, Integer userid) throws Exception {

		User user = us.findByid(userid);
		Post newPost = new Post();
		newPost.setCaption(post.getCaption());
		newPost.setId(post.getId());
		newPost.setImage(post.getImage());
		newPost.setUser(user);
		newPost.setLocalDateAndTime(LocalDateTime.now());
		newPost.setVideo(post.getVideo());

		return newPost;
	}

	@Override
	public String deletPost(Integer postid, Integer userid) throws Exception {
		Post post = findPostById(postid);
		User user = us.findByid(userid);
		if (user.getId() != post.getUser().getId()) {
			throw new Exception("you cannot delete this post");

		}
		postRepo.delete(post);
		return " post deleted succesfully";

	}

	@Override
	public List<Post> findPostByUserid(Integer userid) {

		return postRepo.findPostByUserid(userid);
	}

	@Override
	public Post findPostById(Integer postid) throws Exception {
		Optional<Post> opt = postRepo.findById(postid);
		if (opt.isEmpty()) {
			throw new Exception("no post available with the id " + postid);

		}
		return opt.get();
	}

	@Override
	public List<Post> findAllPost() {
		List<Post> posts = postRepo.findAll();
		return posts;
	}

	@Override
	public Post savedPost(Integer postid, Integer userid) throws Exception {
		Post post = findPostById(postid);
		User user = us.findByid(userid);
		if(user.getSavedPost().contains(post)){
			user.getSavedPost().remove(post);
		}
		else {
			user.getSavedPost().add(post);
		}
		userRepo.save(user);
		return post;
	}

	@Override
	public Post likePost(Integer postid, Integer userid) throws Exception {
		Post post = findPostById(postid);
		User user = us.findByid(userid);
		if (post.getLiked().contains(user)) {
			post.getLiked().remove(user);
		} else {
			post.getLiked().add(user);
		}
		return postRepo.save(post);
	}

}
