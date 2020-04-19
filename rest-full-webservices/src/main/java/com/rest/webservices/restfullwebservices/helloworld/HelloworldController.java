package com.rest.webservices.restfullwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {
	
	@Autowired
	private MessageSource messageSource;
	
	//GET 
	//URI - // hello-world
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello world";
	}
	
	//hello-world-bean
	@GetMapping(path="/hello-world-bean")
	public Helloworldbean helloworldbean() {
		return new Helloworldbean("hello world");
	}


	//hello-world/path-variable
		@GetMapping(path="/hello-world/path-variable/{name}")
		public Helloworldbean helloworldbean(@PathVariable String name) {
			return new Helloworldbean(String.format("hello world,%s ", name));
		}

		/*@GetMapping(path="/hello-world-internationalized")
		public String helloWorldInternationalized(@RequestHeader(name="Accept-Language",required=false) Locale locale) {
			return messageSource.getMessage("good.morning.message",null, locale);
		}*/
		
		@GetMapping(path="/hello-world-internationalized")
		public String helloWorldInternationalized() {
			return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
		}
		
	
}
