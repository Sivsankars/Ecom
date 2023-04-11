package com.baymart.entity;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"emailId", "phoneNo"}))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Nonnull
	private String userName;
	
	@Nonnull
	private String emailId;
	
	@Nonnull
	private Long phoneNo;
	
	@Nonnull
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="userId", referencedColumnName = "userId")
	private List<Address> address;
}
