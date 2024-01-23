package com.umashankar.models;

import java.util.ArrayList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String gender;
	private List<Integer> followers;
	private List<Integer> followings;
	
	
	@ManyToMany
	private List<Post> savedPost = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Integer> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Integer> followers) {
		this.followers = followers;
	}

	public List<Integer> getFollowings() {
		return followings;
	}

	public void setFollowings(List<Integer> followings) {
		this.followings = followings;
	}

	public List<Post> getSavedPost() {
		return savedPost;
	}

	public void setSavedPost(List<Post> savedPost) {
		this.savedPost = savedPost;
	}

	public User(int id, String fname, String lname, String email, String password, String gender,
			List<Integer> followers, List<Integer> followings, List<Post> savedPost) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.followers = followers;
		this.followings = followings;
		this.savedPost = savedPost;
	}

	public User() {
		super();
	}
	
	
	
	
	
	
	
	
	

}
