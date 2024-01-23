package com.umashankar.service;

import com.umashankar.models.Comment;
import com.umashankar.models.User;

public interface CommentService {
	public Comment createComment(Comment comment,Integer postid,Integer userid) throws Exception;
	public Comment likeComment(Integer commentid,Integer userid) throws Exception;
	public Comment findCommentById(Integer commentid) throws Exception;

}
