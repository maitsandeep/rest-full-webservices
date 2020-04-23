package com.rest.webservices.restfullwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@RestController
@EnableAutoConfiguration
public class UserJparesource {
	@Autowired
	private UserDaoservice userDaoservice;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	PostRepository postRepository;
	@GetMapping("/jpa/users")
	public List<User1> retrieveAllUsers() {
		return userRepository.findAll();

	}
	
	@GetMapping("/jpa/users/{id}")
	public Optional<User1> retrieveUser(@PathVariable int id)

	{
		Optional<User1> user=userRepository.findById(id);
		if(user.isPresent())
			throw new UserNotFoundException("id-"+id);
		
		
		return user;

	}
	
	@DeleteMapping("jpa/users/{id}")
	public void deleteUser(@PathVariable int id)

	{
		userRepository.deleteById(id);
	
}
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid  @RequestBody User1 user) {
		User1 saveduser=userRepository.save(user);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
		.buildAndExpand(saveduser.getId()).toUri();
		
	return	ResponseEntity.created(location).build();
		
	}
	
	
	
	
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllUsers(@PathVariable Integer id) {
		Optional<User1>userOptinal =userRepository.findById(id);
		if(!userOptinal.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		
		return userOptinal.get().getPost();
				

	}
	
	
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable Integer id,@RequestBody Post post) {
		Optional<User1>userOptinal =userRepository.findById(id);
		if(!userOptinal.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		User1 saveduser=userOptinal.get();
		post.setUser1(saveduser);
		postRepository.save(post);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
		.buildAndExpand(post.getId()).toUri();
		
	return	ResponseEntity.created(location).build();
		
	}
	
	
	

}
