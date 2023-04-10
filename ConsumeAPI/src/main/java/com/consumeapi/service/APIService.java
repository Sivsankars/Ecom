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

import com.consumeapi.ModelObject.Repos;
import com.consumeapi.ModelObject.User;
import com.consumeapi.repository.ReposRepository;
import com.consumeapi.repository.UserRepository;


@Service
public class APIService {
	
	private final RestTemplate restTemplate;
	private final UserRepository userRepository;
	private final ReposRepository reposRepository;
	
	@Autowired
	public APIService(RestTemplate restTemplate,
			UserRepository userRepository,
			ReposRepository reposRepository) {
		this.restTemplate = restTemplate;
		this.userRepository=userRepository;
		this.reposRepository=reposRepository;
	}
	
	public List<User> consumeAPI() {		
		User users[]= restTemplate.getForObject(
				"https://jsonplaceholder.typicode.com/users", 
				User[].class);
		userRepository.saveAll(Arrays.asList(users));
		return Arrays.asList(users);

	}
	
	public List<Repos> consumeGitAPI(String userName) {
		try {
			Repos[] repos=restTemplate.getForObject(
					new URL("https://api.github.com/users/"+userName+"/repos").toURI(),
					Repos[].class);
			reposRepository.saveAll(Arrays.asList(repos));
			return Arrays.asList(repos);
		} catch (RestClientException | MalformedURLException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
