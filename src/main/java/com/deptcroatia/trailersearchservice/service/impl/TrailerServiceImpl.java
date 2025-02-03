package com.deptcroatia.trailersearchservice.service.impl;

import com.deptcroatia.trailersearchservice.client.YoutubeApiClient;
import com.deptcroatia.trailersearchservice.dto.response.TrailerResponse;
import com.deptcroatia.trailersearchservice.service.TrailerService;
import com.deptcroatia.trailersearchservice.util.mapper.TrailerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrailerServiceImpl implements TrailerService {
    private final YoutubeApiClient youtubeApiClient;

    @Override
    public TrailerResponse getTrailerByTitle(String title, Integer objectsPerPage, String pageToken) {
        return TrailerMapper.toTrailerResponse(youtubeApiClient.searchTrailers(title, objectsPerPage, pageToken));
    }
}
