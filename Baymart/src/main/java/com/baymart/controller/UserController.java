package com.baymart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baymart.dto.UserDto;
import com.baymart.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/registration")
	public String newUserRegistration(UserDto userDto) {
		return userService.register(userDto)+" registered";
	}
}
