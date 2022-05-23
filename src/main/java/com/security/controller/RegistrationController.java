package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.dto.UserDto;
import com.security.entity.User;
import com.security.service.UserService;

@RestController
public class RegistrationController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	public User signup(@RequestBody UserDto user) {
		return userService.save(user);
	}

}
