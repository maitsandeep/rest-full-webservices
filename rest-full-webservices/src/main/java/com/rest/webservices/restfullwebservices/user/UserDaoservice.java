package com.rest.webservices.restfullwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoservice {
	
	private static List<User1> users=new ArrayList<>();
	private static int userCount=3;
	
	static {
		users.add(new User1(1, "sandeep", new Date()));
		users.add(new User1(2, "kumar", new Date()));
		users.add(new User1(3, "tiwari", new Date()));
	}
	
	
	//public List<User> findAll();
	
	public List<User1> findAll(){
		return users;
	}
	
	// public User save(User user)
	
	public User1 save(User1 user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	//public User findOne(int id)
	public User1 findOne(int id)
	{
		for(User1 user:users) {
			if(user.getId()==id) {
				return user;
				
			}
			
		}
		return null;
	}
	

	
	//public User findOne(int id)
	public User1 DeleteById(int id)
	{
		Iterator<User1> iterator=users.iterator();
		
		while(iterator.hasNext()) {
			User1 user=iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
				
			}
			
		}
		return null;
	}
	
}
