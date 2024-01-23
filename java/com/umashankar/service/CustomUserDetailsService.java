package com.umashankar.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.umashankar.models.User;
import com.umashankar.repository.Userreopository;
@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	Userreopository userrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		User user = userrepo.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("username nt found");
		}
		List<GrantedAuthority> authorites = new ArrayList<>();
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorites);
	}

}
