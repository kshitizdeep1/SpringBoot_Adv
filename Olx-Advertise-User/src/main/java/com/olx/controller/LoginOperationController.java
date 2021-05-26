package com.olx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.User;
import com.olx.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginOperationController {

	@Autowired
	UserService userService;

	@ApiOperation(value = "Login user", notes = "user login using username and password")
	@PostMapping(value = "/user/authenticate", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<User> login(@RequestBody User user) {
		return new ResponseEntity<User>(userService.login(user), HttpStatus.OK);
	}

	@ApiOperation(value = "User logout", notes = "log out the user")
	@DeleteMapping(value = "/user/logout")
	public ResponseEntity<User> logOut(@RequestHeader String authToken) {
		if (userService.logout(authToken)) {
			return new ResponseEntity<User>(HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "create user", notes = "create new user")
	@PostMapping(value = "/user", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.OK);
	}

	@ApiOperation(value = "Get user By Id", notes = "Return user details by id")
	@GetMapping(value = "/user", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<User> getUser(@RequestHeader("Auth_Token") String authToken) {

		if (userService.getUser(authToken)) {
			return new ResponseEntity<User>(HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}
}
