package com.baymart.dto;

import lombok.Data;

@Data
public class AddressDto {
	private Long addressId;
	private String addressLine;
	private String state;
	private String district;
	private int pincode;
}
