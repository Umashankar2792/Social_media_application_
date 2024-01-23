package com.umashankar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.umashankar.models.Comment;
import com.umashankar.models.Post;
import com.umashankar.models.User;
import com.umashankar.service.CommentService;
import com.umashankar.service.PostService;
import com.umashankar.service.UserServices;



@RestController
public class CommentController {
	@Autowired
	private UserServices us;
	
	@Autowired
	private PostService ps;
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/api/comments/post/{postid}")
	public Comment createComment(@RequestBody Comment comment,@RequestHeader("Authorization") String jwt,@PathVariable Integer postid) throws Exception {
		User reqUser = us.findUserByJwt(jwt);
		
		Comment createdComment = commentService.createComment(comment, postid, reqUser.getId());
		return createdComment;
	}
	@PutMapping("/api/comments/like/{commentid}")
	public Comment likeComment(@RequestBody Comment comment,@RequestHeader("Authorization") String jwt,@PathVariable Integer commentid) throws Exception {
		User reqUser = us.findUserByJwt(jwt);
		
		Comment likedComment = commentService.likeComment(commentid, reqUser.getId());
		return likedComment;
	}

}

