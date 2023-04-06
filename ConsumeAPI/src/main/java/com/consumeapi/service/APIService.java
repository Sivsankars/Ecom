package com.consumeapi.service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class APIService {
	
	private final RestTemplate restTemplate;
	
	@Autowired
	public APIService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public Object consumeAPI(String userName) {		
		try {
			return restTemplate.getForObject(
					new URL("https://api.github.com/users/"+userName+"/repos").toURI(), 
					Object.class);
		} catch (RestClientException | MalformedURLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}
