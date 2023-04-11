package com.baymart.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long addressId;
	
	@Nonnull
	private String addressLine;
	
	@Nonnull
	private String state;
	
	@Nonnull
	private String district;
	
	@Nonnull
	private int pincode;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userId")
//	private User user;
}
