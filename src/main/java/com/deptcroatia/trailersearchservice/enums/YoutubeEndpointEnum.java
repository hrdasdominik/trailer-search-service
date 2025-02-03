package com.deptcroatia.trailersearchservice.enums;

public enum YoutubeEndpointEnum {
    SEARCH("/search");

    private final String endpoint;

    YoutubeEndpointEnum(String endpoint) {
        this.endpoint = endpoint;
    }

    public String value() {
        return endpoint;
    }
}
