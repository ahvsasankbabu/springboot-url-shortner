package com.urlshortner.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateUrlRequest {
	@NotBlank(message = "URL cannot be empty")
	private String longUrl;
	
	@NotBlank(message= "\"URL cannot be empty")
	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	
	

}
