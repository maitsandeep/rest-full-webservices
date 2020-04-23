package com.rest.webservices.restfullwebservices.user;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Post {
	@Id
	private Integer id;
	private String description;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User1 user1;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User1 getUser1() {
		return user1;
	}
	public void setUser1(User1 user1) {
		this.user1 = user1;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}

	
	
}
