package com.gethealthy.searchservice.controller;

import com.gethealthy.searchservice.model.SearchResult;
import com.gethealthy.searchservice.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/search")
public class SearchController {
    private final SearchService searchService;

    @PostMapping("/all")
    public ResponseEntity<List<SearchResult>> search(@RequestParam String term, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        return searchService.search(term, authorizationHeader);
    }

    @PostMapping("/events")
    public ResponseEntity<List<SearchResult>> searchEvent(@RequestParam String term, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        return searchService.searchEvent(term, authorizationHeader);
    }

    @PostMapping("/illness-records")
    public ResponseEntity<List<SearchResult>> searchIllnessCycle(@RequestParam String term, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        return searchService.searchIllnessRecord(term, authorizationHeader);
    }
}
