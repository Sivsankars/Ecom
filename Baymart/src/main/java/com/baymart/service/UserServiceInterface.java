package com.baymart.service;

import com.baymart.dto.UserDto;

public interface UserServiceInterface {
	public Long register(UserDto userDto);
	public UserDto createUser(UserDto userDto);
}
