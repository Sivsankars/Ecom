package com.baymart.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.baymart.dto.AddressDto;
import com.baymart.dto.UserDto;
import com.baymart.entity.Address;
import com.baymart.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	UserDto toUserDto(User user);
	
	User toUser(UserDto userDto);
}