package com.deptcroatia.trailersearchservice.dto.response;

import com.deptcroatia.trailersearchservice.dto.common.PageInfo;
import com.deptcroatia.trailersearchservice.dto.common.Thumbnail;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record YoutubeApiSearchResponse(
        String nextPageToken,
        String prevPageToken,
        PageInfo pageInfo,
        List<Item> items
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Item(
            Id id,
            Snippet snippet
    ) {
        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Id(
                @JsonProperty("videoId") String videoId,
                @JsonProperty("channelId") String channelId
        ) {
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Snippet(
                String title,
                String description,
                String channelTitle,
                String publishedAt,
                Map<String, Thumbnail> thumbnails) {
        }
    }
}
