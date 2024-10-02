package com.gethealthy.searchservice.feign;

import com.gethealthy.searchservice.model.IllnessRecordDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient("ILLNESS-RECORD-SERVICE")
public interface IllnessRecordInterface {
    @PostMapping("api/v1/illnesses/search")
    ResponseEntity<List<IllnessRecordDTO>> SearchRecords(@RequestParam String term, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader);
}
