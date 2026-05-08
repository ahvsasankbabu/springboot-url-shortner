package com.urlshortner.service;

import org.springframework.stereotype.Service;

import com.urlshortner.dto.CreateUrlRequest;
import com.urlshortner.dto.CreateUrlResponse;
import com.urlshortner.entity.UrlMapping;
import com.urlshortner.repository.UrlMappingRepository;
import com.urlshortner.util.Base62Util;

@Service
public class UrlMappingServiceImpl implements UrlMappingService {
	
	private UrlMappingRepository urlrepo;
	
	public UrlMappingServiceImpl(UrlMappingRepository urlrepo) {
		
		this.urlrepo = urlrepo;
	}

	@Override
	public CreateUrlResponse createShortUrl(CreateUrlRequest request)
	{
		UrlMapping url = new UrlMapping();
		url.setLongUrl(request.getLongUrl());
		
		url = urlrepo.save(url);
		String shortCode = Base62Util.encode(url.getId());
		url.setShortCode(shortCode);
		url = urlrepo.save(url);
		CreateUrlResponse response = new CreateUrlResponse();
		response.setShortUrl(shortCode);

		
			return response;
	}
	
	@Override
	public String getLongUrl(String shortCode)
	{
		UrlMapping url=urlrepo.findByShortCode(shortCode)
		.orElseThrow(() -> new RuntimeException("Short URL not found"));
		return url.getLongUrl();
	}

}
