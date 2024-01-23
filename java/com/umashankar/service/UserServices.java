package com.umashankar.service;

import java.util.List;

import com.umashankar.Exceptions.UserException;
import com.umashankar.models.User;

public interface UserServices {
	public User registerUser(User user);
	public User findByid(Integer userid) throws UserException;
	public User findByEmail(String email);
	public User followUser(Integer userid1,Integer userid2) throws UserException;
	public User updateUser(User user,Integer userid) throws UserException;
	public List<User> Searchuser(String query);
	public User findUserByJwt(String jwt);
	
	

}
