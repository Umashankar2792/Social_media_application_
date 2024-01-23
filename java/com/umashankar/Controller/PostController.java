package com.umashankar.Controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;import org.springframework.web.service.invoker.HttpExchangeAdapter;

import com.umashankar.models.Post;
import com.umashankar.models.User;
import com.umashankar.response.ApiResponse;
import com.umashankar.service.PostService;
import com.umashankar.service.UserServices;

@RestController
public class PostController {
	@Autowired
	PostService ps;
	@Autowired
	UserServices us;
	
	
	@PostMapping("/api/posts")
	public ResponseEntity<Post> createNewPost(@RequestBody Post post,@RequestHeader("Authorization")String jwt) throws Exception{
		User reqUser = us.findUserByJwt(jwt);
		Post createdPost = ps.createNewPost(post, reqUser.getId());
		return new ResponseEntity<>(createdPost,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/api/posts/{postid}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postid,@RequestHeader("Authorization")String jwt) throws Exception{
		User reqUser = us.findUserByJwt(jwt);
		String message =ps.deletPost(postid, reqUser.getId());
		ApiResponse res = new ApiResponse(message,true);
		
		return new ResponseEntity<ApiResponse>(res,HttpStatus.OK);
		
	}
	@GetMapping("/api/posts/{postid}")
	public ResponseEntity<Post> findPostByIdHandler(@PathVariable Integer postid) throws Exception{
		Post post = ps.findPostById(postid);
		
		return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/api/posts/user/{userid}")
	public ResponseEntity<List<Post>> findUsersPost(@PathVariable Integer userid)throws Exception{
		List<Post> posts = ps.findPostByUserid(userid);
		return new ResponseEntity<>(posts, HttpStatus.OK);
		
	}
	
	@GetMapping("/api/posts")
	public ResponseEntity<List<Post>> findAllPosts(){
		List<Post> posts = ps.findAllPost();
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	@GetMapping("/api/posts/{postid}/user/{userid}")
	public ResponseEntity<Post> savedPostByIdHandler(@PathVariable Integer postid,@PathVariable Integer userid) throws Exception{
		Post post = ps.savedPost(postid,userid);
		
		return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/api/posts/like/{postid}")
	public ResponseEntity<Post> likedPostByIdHandler(@PathVariable Integer postid,@RequestHeader("Authorization")String jwt) throws Exception{
		User reqUser = us.findUserByJwt(jwt);
		
		Post post = ps.likePost(postid,reqUser.getId());
		
		return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
		
	}
	

		
	
	
	

}
