package com.deptcroatia.trailersearchservice.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PageInfo(int totalResults, int resultsPerPage) {
}