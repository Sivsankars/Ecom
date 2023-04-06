package com.consumeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumeapi.service.APIService;

@RestController
public class RequestController {
	
	private final APIService apiService;
	
	@Autowired
	public RequestController(APIService apiService) {
		this.apiService = apiService;
	}


	@GetMapping("/")
	public Object getData() {
		return apiService.consumeAPI(); 
	}
}
