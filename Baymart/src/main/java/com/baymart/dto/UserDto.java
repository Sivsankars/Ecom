package com.baymart.dto;

import lombok.Data;

@Data
public class UserDto {
	private String userName;
	private String emailId;
	private Long phoneNo;
	private String password;
}
