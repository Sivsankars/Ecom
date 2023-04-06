package com.consumeapi.service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

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
	
	public User consumeAPI() {		
		try {
			return restTemplate.getForObject(
					new URL("https://jsonplaceholder.typicode.com/users/1").toURI(), 
					User.class);
		} catch (RestClientException | MalformedURLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}
