package com.urlshortner.service;

import com.urlshortner.dto.CreateUrlRequest;
import com.urlshortner.dto.CreateUrlResponse;

public interface UrlMappingService {
	
	CreateUrlResponse createShortUrl(CreateUrlRequest request);
	String getLongUrl(String shortCode);

}
