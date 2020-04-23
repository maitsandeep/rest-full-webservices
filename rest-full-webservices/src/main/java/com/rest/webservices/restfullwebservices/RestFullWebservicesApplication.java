package com.rest.webservices.restfullwebservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
@ComponentScan
public class RestFullWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestFullWebservicesApplication.class, args);
	}

	
	@Bean
	public LocaleResolver localeResolver() {
		//SessionLocaleResolver localeResolver=new SessionLocaleResolver();
		AcceptHeaderLocaleResolver localeResolver=new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	@Bean 
	public ResourceBundleMessageSource  bundleMessageSource() {
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		
		messageSource.setBasename("messages");
		return messageSource;
	}
}
