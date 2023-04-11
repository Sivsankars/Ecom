package com.baymart.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.baymart.dto.UserDto;
import com.baymart.entity.User;
import com.baymart.mapper.UserMapper;
import com.baymart.repository.UserRepository;

@Service
public class UserService implements UserServiceInterface {
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private Logger logger=LoggerFactory.getLogger(UserService.class);
	private UserMapper userMapper;
	
	@Autowired
	public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
			UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userMapper = userMapper;
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
		logger.debug("User with id "+user.getUserId()+" registered");
		return user.getUserId();
	}
	
	

	public UserDto createUser(UserDto userDto) {
		userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		User user = UserMapper.INSTANCE.toUser(userDto);
		user = userRepository.save(user);
		return UserMapper.INSTANCE.toUserDto(user);
	}
	
}
