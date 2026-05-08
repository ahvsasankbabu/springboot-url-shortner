package com.urlshortner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urlshortner.dto.CreateUrlRequest;
import com.urlshortner.dto.CreateUrlResponse;
import com.urlshortner.service.UrlMappingServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/urls")
public class UrlMappingController {
	
	private UrlMappingServiceImpl urlMappingService;

	public UrlMappingController(UrlMappingServiceImpl urlMappingService) {
		
		this.urlMappingService = urlMappingService;
	}
	
	@PostMapping
	public ResponseEntity<CreateUrlResponse> createShortUrl(@Valid @RequestBody CreateUrlRequest request) {
	    CreateUrlResponse response = urlMappingService.createShortUrl(request);
	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}


}
