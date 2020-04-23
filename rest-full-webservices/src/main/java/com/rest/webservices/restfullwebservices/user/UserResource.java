package com.rest.webservices.restfullwebservices.user;

import java.net.URI;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;
//import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;*/
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	@Autowired(required=true)
	private UserDaoservice userDaoservice;

	// Get /users
	// retrieveAllUsers()
	@GetMapping("/users")
	public List<User1> retrieveAllUsers() {
		return userDaoservice.findAll();

	}

	// retrieveUser(int id)
	@GetMapping("/users/{id}")
	public User1 retrieveUser(@PathVariable int id)

	{
		User1 user=userDaoservice.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id-"+id);
		
		
		return user;

	}
	
	
	// retrieveUser(int id)
	/*	@GetMapping("/users/{id}")
		public EntityModel<User> retrieveUser(@PathVariable int id)

		{
			User user=userDaoservice.findOne(id);
			if(user==null)
				throw new UserNotFoundException("id-"+id);
			//Resource<User> resource=new Resource<>();
			
			EntityModel<User> resource = new EntityModel<User>(user);
	        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
	        resource.add(linkTo.withRel("all-users"));
			
			return resource;

		}*/
		
	
	
	
	
	// retrieveUser(int id)
		@DeleteMapping("/users/{id}")
		public void deleteUser(@PathVariable int id)

		{
			User1 user=userDaoservice.DeleteById(id);
			if(user==null)
				throw new UserNotFoundException("id-"+id); 	
			
			
			

		}
		
	
	
	//Created
	//input -details of users
	//output-create and return the created URI
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid  @RequestBody User1 user) {
		User1 saveduser=userDaoservice.save(user);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
		.buildAndExpand(saveduser.getId()).toUri();
		
	return	ResponseEntity.created(location).build();
		
	}

}
