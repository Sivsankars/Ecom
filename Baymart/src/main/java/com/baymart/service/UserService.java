package com.baymart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.baymart.dto.UserDto;
import com.baymart.entity.User;
import com.baymart.repository.UserRepository;

@Service
public class UserService implements UserServiceInterface {
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	public Long register(UserDto userDto) {
		User user= User.builder()
				.userName(userDto.getUserName())
				.emailId(userDto.getEmailId())
				.phoneNo(userDto.getPhoneNo())
				.password(bCryptPasswordEncoder.encode(userDto.getPassword()))
				.build();
		userRepository.save(user);
		return user.getUserId();
	}
	
}
