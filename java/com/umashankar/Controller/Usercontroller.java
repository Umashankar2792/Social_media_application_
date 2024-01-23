package com.umashankar.Controller;
import com.umashankar.Exceptions.UserException;
import com.umashankar.models.*;
import com.umashankar.repository.Userreopository;
import com.umashankar.service.UserServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Usercontroller {
	@Autowired
	Userreopository userrepo;
	@Autowired
	UserServices us;
	
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user){
		
		return us.registerUser(user);
				
		
		
	}
	@GetMapping("/api/users")
public List<User> getUsers(){
	List<User> users = userrepo.findAll();
	
	return users;
	
	
}
@GetMapping("/api/users/{userid}")
public User getUsers(@PathVariable Integer userid)throws UserException{
	User user = us.findByid(userid);
	return user;
	
}

@PutMapping("/api/users")
public User updateuser(@RequestHeader("Authorization")String jwt,@ RequestBody User user)throws UserException {
	User requser = us.findUserByJwt(jwt);
	
	User updateduser = us.updateUser(user,requser.getId());
	
	return updateduser;
}
@PutMapping("/api/users/{userid2}")
public  User followHandler(@RequestHeader("Authorization")String jwt, @PathVariable Integer userid2) throws UserException {
	User reqUser = us.findUserByJwt(jwt);
	
	User follower= us.followUser(reqUser.getId(), userid2);
	return follower;
}
@DeleteMapping("/api/users/{userid}")
public String deleteuser(@PathVariable("userid") Integer userid) {
	return "user deleted succesfully with userid "+userid;
	
}
@GetMapping("/api/users/search")
public List<User> Searchuser(@RequestParam ("query") String query){
	List<User> users = us.Searchuser(query);
	
	return users;
	
}
@GetMapping("/api/users/profile")
public User getUserFromToken(@RequestHeader("Authorization")String jwt) {
	
	User user = us.findUserByJwt(jwt);
	return user;
	
}



}
