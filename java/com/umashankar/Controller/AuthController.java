package com.umashankar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umashankar.Request.LoginRequest;
import com.umashankar.config.JwtProvider;
import com.umashankar.models.User;
import com.umashankar.repository.Userreopository;
import com.umashankar.response.AuthResponse;
import com.umashankar.service.CustomUserDetailsService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	Userreopository userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	CustomUserDetailsService customUserDetails;
	
	@PostMapping("/signup")
	public AuthResponse createUser(@RequestBody User user) throws Exception{
		User isExist = userRepo.findByEmail(user.getEmail());
		if(isExist!=null) {
			throw new Exception("email already used with another account");
			
		}
		
		User newuser = new User();
		newuser.setEmail(user.getEmail());
		newuser.setFname(user.getFname());
		newuser.setId(user.getId());
		newuser.setLname(user.getLname());
		newuser.setPassword(passwordEncoder.encode(user.getPassword()));
		
		User saveduser =userRepo.save(newuser);
		Authentication authentication = new UsernamePasswordAuthenticationToken(saveduser.getEmail(),saveduser.getPassword());
		String token = JwtProvider.generateToken(authentication);
		AuthResponse res= new AuthResponse(token,"Register Success");
		return res;
				
		
		
	}
	@PostMapping("/signin")
	public AuthResponse signin(@RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticate(loginRequest.getEmail(),loginRequest.getPassword());
		String token = JwtProvider.generateToken(authentication);
		AuthResponse res= new AuthResponse(token,"login Success");
		return res;
	}
	private Authentication authenticate(String email, String password) {
		UserDetails userDetails = customUserDetails.loadUserByUsername(email);
		if(userDetails==null) {
			throw new BadCredentialsException("invalid username");
			
		}
		if(!passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("invalid username and password");
			
		}
		return new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
	}

}
