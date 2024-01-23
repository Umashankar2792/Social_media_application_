package com.umashankar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.umashankar.models.User;

public interface Userreopository extends JpaRepository<User, Integer>{

	public User findByEmail(String email);
	@Query("select u from User u where u.fname LIKE %:query% OR u.lname LIKE %:query% OR u.email LIKE %:query%")
	public List<User> Searchuser(@Param("query")String query);
	

}
