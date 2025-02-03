package com.deptcroatia.trailersearchservice.util.mapper;

import com.deptcroatia.trailersearchservice.dto.response.TrailerResponse;
import com.deptcroatia.trailersearchservice.dto.response.YoutubeApiSearchResponse;


public class TrailerMapper {
    private static final String YOUTUBE_VIDEO_BASE_URL = "https://www.youtube.com/watch?v=";
    private static final String YOUTUBE_CHANNEL_BASE_URL = "https://www.youtube.com/channel/";

    private TrailerMapper() {
    }

    public static TrailerResponse toTrailerResponse(YoutubeApiSearchResponse youtubeApiSearchResponse) {
        return new TrailerResponse(
                youtubeApiSearchResponse.nextPageToken(),
                youtubeApiSearchResponse.prevPageToken(),
                youtubeApiSearchResponse.pageInfo(),
                youtubeApiSearchResponse.items().stream().map(TrailerMapper::toTrailerResultResponse).toList()
        );
    }

    private static TrailerResponse.TrailerResultResponse toTrailerResultResponse(YoutubeApiSearchResponse.Item item) {
        return new TrailerResponse.TrailerResultResponse(
                item.snippet().title(),
                YOUTUBE_VIDEO_BASE_URL + item.id().videoId(),
                item.snippet().channelTitle(),
                YOUTUBE_CHANNEL_BASE_URL + item.id().channelId(),
                item.snippet().description(),
                item.snippet().publishedAt(),
                item.snippet().thumbnails().get("high")
        );
    }
}
