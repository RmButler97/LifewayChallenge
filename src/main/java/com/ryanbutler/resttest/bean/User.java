package com.ryanbutler.resttest.bean;

public class User {
	private String id;
	private String message;
	
	public User() {}
	
	public User(String id, String message) {
		this.id = id;
		this.message = message;
	}
	
	public String getId() {
		return id;
	}
	
	public String getMessage() {
		return message;
	}
	
}