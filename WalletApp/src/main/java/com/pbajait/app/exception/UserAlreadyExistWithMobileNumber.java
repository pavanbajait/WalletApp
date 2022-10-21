package com.pbajait.app.exception;

public class UserAlreadyExistWithMobileNumber extends RuntimeException{

	public UserAlreadyExistWithMobileNumber() {
		
	}
	
	public UserAlreadyExistWithMobileNumber(String message) {
		super(message);
	}
}