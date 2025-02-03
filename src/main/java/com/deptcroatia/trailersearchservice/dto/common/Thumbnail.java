package com.deptcroatia.trailersearchservice.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Thumbnail(String url, int width, int height) {
}
