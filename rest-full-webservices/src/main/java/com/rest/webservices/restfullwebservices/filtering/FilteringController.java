package com.rest.webservices.restfullwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	/*//field1 and field2
	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		SomeBean someBean= new SomeBean("valie1","valie2","valie3");
		MappingJacksonValue mapping=new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("someBeanFilte", filter);
		mapping.setFilters(filters);
		
		return someBean;
	}*/
	
	//field1 and field2
		@GetMapping("/filtering")
		public MappingJacksonValue retrieveSomeBean() {
			SomeBean someBean= new SomeBean("valie1","valie2","valie3");
			
			SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("filed1","filed1");
			FilterProvider filters=new SimpleFilterProvider().addFilter("someBeanFilter", filter);
			MappingJacksonValue mapping=new MappingJacksonValue(someBean);
			mapping.setFilters(filters);
			
			return mapping;
		}
//field2,field3
	@GetMapping("/filtering-list")
	public  List<SomeBean> retrieveListSomeBean() {
		return Arrays.asList(new SomeBean("valie1","valie2","valie3"),new SomeBean("valie12","valie22","valie32")) ;
	}
}
