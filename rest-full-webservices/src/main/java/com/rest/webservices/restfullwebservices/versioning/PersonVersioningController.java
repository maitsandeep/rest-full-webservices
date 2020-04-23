package com.rest.webservices.restfullwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("sandeep kumar tiwari");
	}
	
	
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2( new Name("sandeep",  "tiwari"));
	}
	
	
	
	@GetMapping(value="person/param",params="version=1")
	public PersonV1 paramV1() {
		return new PersonV1("sandeep kumar tiwari");
	}
	
	
	@GetMapping(value="person/param",params="version=2")
	public PersonV2 paramV2() {
		return new PersonV2( new Name("sandeep",  "tiwari"));
	}

	
	
	
	@GetMapping(value="person/header",headers="x-api-version=1")
	public PersonV1 headerV1() {
		return new PersonV1("sandeep kumar tiwari");
	}
	
	
	@GetMapping(value="person/header",headers="x-api-version=2")
	public PersonV2 headerV2() {
		return new PersonV2( new Name("sandeep",  "tiwari"));
	}
	
	
	@GetMapping(value="person/produce",produces="application/vnd.company.app-v1+jason")
	public PersonV1 produceV1() {
		return new PersonV1("sandeep kumar tiwari");
	}
	
	
	@GetMapping(value="person/produce",produces="application/vnd.company.app-v2+jason")
	public PersonV2 produceV2() {
		return new PersonV2( new Name("sandeep",  "tiwari"));
	}


}
