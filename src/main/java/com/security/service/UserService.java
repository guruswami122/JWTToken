package com.security.service;

import java.util.List;

import com.security.dto.UserDto;
import com.security.entity.User;

public interface UserService {
	
	User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
    User findById(int id);

}
