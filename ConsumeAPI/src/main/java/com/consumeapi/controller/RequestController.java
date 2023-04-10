package com.consumeapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consumeapi.ModelObject.Repos;
import com.consumeapi.ModelObject.User;
import com.consumeapi.service.APIService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class RequestController {
	
	private final APIService apiService;
	
	@Autowired
	public RequestController(APIService apiService) {
		this.apiService = apiService;
	}

	@GetMapping("/gitUser{userName}")
	public List<Repos> getRepo(@RequestParam("userName") String userName) {
		return apiService.consumeGitAPI(userName);
	}
	
	@GetMapping("/apiUser")
	public ResponseEntity<List<User>> getData() {
		return new ResponseEntity<>(apiService.consumeAPI(),HttpStatus.OK); 
	}
}
