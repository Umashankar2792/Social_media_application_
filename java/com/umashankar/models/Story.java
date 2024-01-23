package com.umashankar.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class Story {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String image;
	private String caption;
	@ManyToOne
	private User user;
	private LocalDateTime timeStamp;

}
