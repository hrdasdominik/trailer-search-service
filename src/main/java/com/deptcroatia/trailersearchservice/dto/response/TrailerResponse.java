package com.deptcroatia.trailersearchservice.dto.response;

import com.deptcroatia.trailersearchservice.dto.common.PageInfo;
import com.deptcroatia.trailersearchservice.dto.common.Thumbnail;

import java.util.List;

public record TrailerResponse(
        String nextPageToken,
        String prevPageToken,
        PageInfo pageInfo,
        List<TrailerResultResponse> items
) {
    public record TrailerResultResponse(
            String title,
            String videoUrl,
            String channelTitle,
            String channelUrl,
            String description,
            String publishedAt, //TODO: Localize date and time for the user
            Thumbnail thumbnail
    ) {
    }
}
