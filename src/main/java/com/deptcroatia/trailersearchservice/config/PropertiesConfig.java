package com.deptcroatia.trailersearchservice.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@Getter
public class PropertiesConfig {
    @Value("${youtube.api.key}")
    private String youtubeApiKey;

    @Value("${youtube.api.url}")
    private String youtubeApiUrl;

    @PostConstruct
    public void printValues() {
        log.debug("YOUTUBE_API_KEY: {}", youtubeApiKey);
        log.debug("YOUTUBE_API_URL: {}", youtubeApiUrl);
    }
}
