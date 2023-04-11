package com.baymart.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserDto {
	private Long userId;
	private String userName;
	private String emailId;
	private Long phoneNo;
	private String password;
	private List<AddressDto> address;
}
