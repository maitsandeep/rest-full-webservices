package com.rest.webservices.restfullwebservices.filtering;

import java.util.Arrays;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("valie1","valie2","valie3");
	}

	@GetMapping("/filtering-list")
	public  List<SomeBean> retrieveListSomeBean() {
		return Arrays.asList(new SomeBean("valie1","valie2","valie3"),new SomeBean("valie12","valie22","valie32")) ;
	}
}
