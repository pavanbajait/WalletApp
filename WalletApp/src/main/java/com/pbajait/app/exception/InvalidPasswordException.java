package com.pbajait.app.exception;


public class InvalidPasswordException extends RuntimeException{

	public InvalidPasswordException() {
		super();
	}
	public InvalidPasswordException(String message) {
		super(message);
	}
}