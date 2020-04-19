package com.rest.webservices.restfullwebservices.exception;

import java.util.Date;


public class ExceptionResposne {
	//timestamp
	private Date timestamp;
	//message
	private String message;
	//details
	private String details;
	public ExceptionResposne(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	

}
