package com.deptcroatia.trailersearchservice.client;

import com.deptcroatia.trailersearchservice.config.PropertiesConfig;
import com.deptcroatia.trailersearchservice.dto.response.YoutubeApiSearchResponse;
import com.deptcroatia.trailersearchservice.enums.YoutubeEndpointEnum;
import com.deptcroatia.trailersearchservice.exception.YoutubeApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Slf4j
@Component
@RequiredArgsConstructor
public class YoutubeApiClient {
    private final WebClient webClient;
    private final PropertiesConfig propertiesConfig;

    private static final int MOVIE_RELATED_VIDEOS_VALUE = 44;

    public YoutubeApiSearchResponse searchTrailers(String title, Integer objectsPerPage, String pageToken) throws YoutubeApiException {
        log.info("Searching trailers for {}; objectsPerPage: {}; pageToken: {};", title, objectsPerPage, pageToken);

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(YoutubeEndpointEnum.SEARCH.value())
                        .queryParam("part", "snippet")
                        .queryParam("q", title + " official movie trailer")
                        .queryParam("type", "video")
                        .queryParam("videoDuration", "short")
                        .queryParam("videoCategoryId", MOVIE_RELATED_VIDEOS_VALUE)
                        .queryParam("key", propertiesConfig.getYoutubeApiKey())
                        .queryParam("maxResults", objectsPerPage)
                        .queryParam("pageToken", pageToken)
                        .build())
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse ->
                        clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(new YoutubeApiException("YouTube API error: " + errorBody)))
                )
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse ->
                        clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(new YoutubeApiException("YouTube Server Error: " + errorBody)))
                )
                .bodyToMono(YoutubeApiSearchResponse.class)
                .block();
    }
}
