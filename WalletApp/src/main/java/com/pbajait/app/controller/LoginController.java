package com.pbajait.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pbajait.app.entity.CustomerDTO;
import com.pbajait.app.exception.NotFoundException;
import com.pbajait.app.service.CustomerLogInImpl;
import com.pbajait.app.service.CustomerLogin;

@RestController
public class LoginController {
	
	@Autowired
	private CustomerLogin customerLogIn;

	// for user Login
	@PostMapping(value = "/login")
	public ResponseEntity<String> logInCustomer(@Valid @RequestBody CustomerDTO customerDTO) throws NotFoundException{
		String res = customerLogIn.logIntoAccount(customerDTO);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	
	// for user Logout
	@PatchMapping(value = "/logout")
	public ResponseEntity<String> logOutCustomer(@RequestParam(required = false) String key) {
		String res = customerLogIn.logOutFromAccount(key);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}

}
