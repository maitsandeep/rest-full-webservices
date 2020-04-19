package com.rest.webservices.restfullwebservices.helloworld;

public class Helloworldbean {
	
	private String messge;
public	Helloworldbean(String messge){
	this.messge=messge;
		
	}
public String getMessge() {
	return messge;
}
public void setMessge(String messge) {
	this.messge = messge;
}
@Override
public String toString() {
	return "Helloworldbean [messge=" + messge + "]";
}



}
