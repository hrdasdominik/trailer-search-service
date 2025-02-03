package com.deptcroatia.trailersearchservice.controller;

import com.deptcroatia.trailersearchservice.dto.response.TrailerResponse;
import com.deptcroatia.trailersearchservice.service.TrailerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/trailer")
@RequiredArgsConstructor
@Validated
public class TrailerController {
    private final TrailerService trailerService;

    @Operation(
            summary = "Search for movie trailers",
            description = "Fetches trailers from YouTube with pagination"
    )
    @GetMapping("search")
    public ResponseEntity<TrailerResponse> getTrailersByTitle(
            @Parameter(description = "Title of the movie trailer") @RequestParam @NotBlank(message = "Title cannot be null") String title,
            @Parameter(description = "Objects returned per page") @RequestParam(defaultValue = "10") @Min(1) @Max(100) Integer objectsPerPage,
            @Parameter(description = "Page token for pagination") @RequestParam(required = false) String pageToken) {
        return ResponseEntity.ok(trailerService.getTrailerByTitle(title, objectsPerPage, pageToken));
    }
}
