package com.consumeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consumeapi.service.APIService;

@RestController
public class RequestController {
	
	private final APIService apiService;
	
	@Autowired
	public RequestController(APIService apiService) {
		this.apiService = apiService;
	}


	@GetMapping("/gitUser")
	public Object getData(@RequestParam("userName") String userName) {
		return apiService.consumeAPI(userName); 
	}
}
