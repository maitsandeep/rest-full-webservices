package com.rest.webservices.restfullwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {
	
	//GET 
	//URI - // hello-world
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello world";
	}

}
