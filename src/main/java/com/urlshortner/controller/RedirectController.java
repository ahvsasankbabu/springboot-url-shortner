package com.urlshortner.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.urlshortner.service.UrlMappingService;

@RestController
public class RedirectController {

    private final UrlMappingService urlMappingService;

    public RedirectController(UrlMappingService urlMappingService) {
        this.urlMappingService = urlMappingService;
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {

        String longUrl = urlMappingService.getLongUrl(shortCode);

        return ResponseEntity.status(302)
                .header("Location", longUrl)
                .build();
    }
}