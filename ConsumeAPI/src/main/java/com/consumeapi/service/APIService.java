package com.consumeapi.service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.consumeapi.ModelObject.User;

@Service
public class APIService {
	
	private final RestTemplate restTemplate;
	
	@Autowired
	public APIService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public List<User> consumeAPI() {		
		System.out.println("hi");
		User users[]= restTemplate.getForObject(
				"https://jsonplaceholder.typicode.com/users", 
				User[].class);
		for(int i=0;i<users.length;i++) {
			System.out.println(users[i]);
		}
		return Arrays.asList(users);

	}
}
