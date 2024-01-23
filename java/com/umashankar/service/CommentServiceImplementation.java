package com.umashankar.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umashankar.models.Comment;
import com.umashankar.models.Post;
import com.umashankar.models.User;
import com.umashankar.repository.CommentRepository;
import com.umashankar.repository.PostRepository;
@Service
public class CommentServiceImplementation implements CommentService{
	@Autowired
	private PostService ps;
	@Autowired
	private UserServices us;
	@Autowired
	private CommentRepository commentRepo;
	@Autowired
	private PostRepository postRepo;
	 
	

	@Override
	public Comment createComment(Comment comment, Integer postid, Integer userid) throws Exception {
		User user = us.findByid(userid);
		Post post = ps.findPostById(postid);
		comment.setUser(user);
		comment.setContent(comment.getContent());
		comment.setCreatedAt(LocalDateTime.now());
		Comment savedComment = commentRepo.save(comment);
		post.getComments().add(savedComment);
		postRepo.save(post);
		
		
		return savedComment;
	}

	@Override
	public Comment likeComment(Integer commentid, Integer userid) throws Exception {
		Comment comment = findCommentById(commentid);
		User user = us.findByid(userid);
		if(!comment.getLiked().contains(user)) {
			comment.getLiked().add(user);
		}
		else comment.getLiked().remove(user);
		
		return commentRepo.save(comment);
	}

	@Override
	public Comment findCommentById(Integer commentid) throws Exception {
		Optional<Comment> opt = commentRepo.findById(commentid);
		if(opt.isEmpty()) {
			throw new Exception("comment does not exist");
			
		}
		
		
		return opt.get();
	}

}
