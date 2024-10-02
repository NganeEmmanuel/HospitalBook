package com.gethealthy.searchservice.feign;

import com.gethealthy.searchservice.model.EventDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient("EVENT-SERVICE")
public interface EventInterface {
    @PostMapping("api/v1/events/search")
    ResponseEntity<List<EventDTO>> searchEvents(@RequestParam String term, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader);
}
