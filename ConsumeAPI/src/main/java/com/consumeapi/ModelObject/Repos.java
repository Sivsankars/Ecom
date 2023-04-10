package com.consumeapi.ModelObject;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Repos {
	@Id
	private int id;
	private String name;
	private boolean fork;
	private long size;
	private String language;
	@OneToOne(cascade = CascadeType.ALL)
	private Owner owner;
}
