package com.umashankar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Reels {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String Video;
	private String Tittle;
	@ManyToOne
	private User user;
	

}
