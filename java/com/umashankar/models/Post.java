package com.umashankar.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String caption;
	private String image;
	private String video;
	private LocalDateTime LocalDateAndTime;
	@OneToMany
	private List<Comment> comments = new ArrayList<>();
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public LocalDateTime getLocalDateAndTime() {
		return LocalDateAndTime;
	}
	public void setLocalDateAndTime(LocalDateTime localDateTime) {
		LocalDateAndTime = localDateTime;
	}
	@JsonIgnore
	@ManyToOne
	private User user;
	
	@OneToMany
	List<User> liked = new ArrayList<>();
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Post() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public List<User> getLiked() {
		return liked;
	}
	public void setLiked(List<User> liked) {
		this.liked = liked;
	}
	public Post(Integer id, String caption, String image, String video, LocalDateTime localDateAndTime,
			List<Comment> comments, User user, List<User> liked) {
		super();
		this.id = id;
		this.caption = caption;
		this.image = image;
		this.video = video;
		LocalDateAndTime = localDateAndTime;
		this.comments = comments;
		this.user = user;
		this.liked = liked;
	}

	

}
