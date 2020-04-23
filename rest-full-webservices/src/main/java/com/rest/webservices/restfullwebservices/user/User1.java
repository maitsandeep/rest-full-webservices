package com.rest.webservices.restfullwebservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="All details About User")
@Entity
public class User1 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; 
	@Size(min=2,max=15,message="name should have more than 2 char and max 15 char")
	@ApiModelProperty(notes="name should have more than 2 char and max 15 char")
	private String name;
	@Past
	@ApiModelProperty(notes="birth date should in the past")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date birthdate;
	@OneToMany(fetch = FetchType.LAZY,mappedBy="user1")
	private List<Post> post;
	protected User1() {
		
	}
	public User1(Integer id, String name, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	
	public List<Post> getPost() {
		return post;
	}
	public void setPost(List<Post> post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}
	

}
