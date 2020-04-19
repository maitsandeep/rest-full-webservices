package com.rest.webservices.restfullwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoservice {
	
	private static List<User> users=new ArrayList<>();
	private static int userCount=3;
	
	static {
		users.add(new User(1, "sandeep", new Date()));
		users.add(new User(2, "kumar", new Date()));
		users.add(new User(3, "tiwari", new Date()));
	}
	
	
	//public List<User> findAll();
	
	public List<User> findAll(){
		return users;
	}
	
	// public User save(User user)
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	//public User findOne(int id)
	public User findOne(int id)
	{
		for(User user:users) {
			if(user.getId()==id) {
				return user;
				
			}
			
		}
		return null;
	}
	

	
	//public User findOne(int id)
	public User DeleteById(int id)
	{
		Iterator<User> iterator=users.iterator();
		
		while(iterator.hasNext()) {
			User user=iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
				
			}
			
		}
		return null;
	}
	
}
