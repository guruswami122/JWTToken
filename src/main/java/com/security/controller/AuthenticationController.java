package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.config.JwtTokenUtil;
import com.security.dto.ApiResponse;
import com.security.dto.AuthToken;
import com.security.entity.LoginUser;
import com.security.entity.User;
import com.security.service.UserService;

@RestController
public class AuthenticationController {
	
	@Autowired
	UserService userService;
	
	 @Autowired
	 JwtTokenUtil jwtTokenUtil;
	 
	 @Autowired
	 AuthenticationManager authenticationManager;

	 @PostMapping("/generate-token")
	 public ApiResponse<AuthToken> register(@RequestBody LoginUser loginUser) throws AuthenticationException {
		 
		 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(),loginUser.getPassword()));
		 final User user = userService.findOne(loginUser.getUsername());
	     final String token = jwtTokenUtil.generateToken(user);
	     return new  ApiResponse<>(200, "success", new AuthToken(token, user.getUsername()));
	 }
}
