package com.pbajait.app.entity;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CustomerDTO {

	@Size(min=10,max=10,message = "{moblie.invalid}")
	private String mobileNo;
	
	@Size(min = 3, max = 10, message = "Password must be min size of 3 characters and max of 10 characters")
	private String password;
}