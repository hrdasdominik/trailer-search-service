package com.deptcroatia.trailersearchservice.service;

import com.deptcroatia.trailersearchservice.dto.response.TrailerResponse;

public interface TrailerService {
    TrailerResponse getTrailerByTitle(String title, Integer objectsPerPage, String pageToken);
}
