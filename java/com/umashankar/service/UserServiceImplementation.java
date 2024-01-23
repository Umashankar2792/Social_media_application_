package com.umashankar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.umashankar.Exceptions.UserException;
import com.umashankar.config.JwtProvider;
import com.umashankar.models.User;
import com.umashankar.repository.Userreopository;
@Service
public class UserServiceImplementation implements UserServices {
	@Autowired
	Userreopository userRepo;

	@Override
	public User registerUser(User user) {
		User newuser = new User();
		newuser.setEmail(user.getEmail());
		newuser.setFname(user.getFname());
		newuser.setId(user.getId());
		newuser.setLname(user.getLname());
		newuser.setPassword(user.getPassword());
		User saveduser =userRepo.save(newuser);
		
		return saveduser;
	}

	@Override
	public User findByid(Integer userid) throws UserException {
		Optional<User> user = userRepo.findById(userid);
		if(user.isPresent()) {
			return user.get();
		}
		
		throw new UserException("no id with this id");
	}

	@Override
	public User findByEmail(String email) {
	User user = userRepo.findByEmail(email);
		return user;
	}

	@Override
	public User followUser(Integer reqUserId, Integer userid2) throws UserException {
	User reqUser = findByid(reqUserId);
	User user2 = findByid(userid2);
	user2.getFollowers().add(reqUserId);
	reqUser.getFollowings().add(userid2);
	userRepo.save(reqUser);
	userRepo.save(user2);
		return reqUser;
	}

	@Override
	public User updateUser(User user,Integer userid) throws UserException {
		Optional<User> user1 = userRepo.findById(userid);
		if(user1.isEmpty()) {
			throw new UserException("it is an error as no user with such id");
			
		}
		User olduser = user1.get();
		if(olduser.getFname()!=null) {
			olduser.setFname(user.getFname());
		}
		if(olduser.getEmail()!=null) {
			olduser.setEmail(user.getEmail());
		}
		if(olduser.getFollowers()!=null) {
			olduser.setFollowers(user.getFollowers());
			
		}
		if(olduser.getFollowings()!=null) {
			olduser.setFollowings(user.getFollowings());
		}
		if(olduser.getGender()!=null) {
			olduser.setGender(user.getGender());
			
		}
		
		
		return userRepo.save(olduser);
	}

	@Override
	
	public List<User> Searchuser(@Param("query")String query) {
	
		return userRepo.Searchuser(query);
	}

	@Override
	public User findUserByJwt(String jwt) {
		String email = JwtProvider.getEmailforJwtToken(jwt);
		User user = userRepo.findByEmail(email);
		return null;
	}

}
