package com.gethealthy.searchservice.model;

import com.gethealthy.searchservice.enums.EventType;
import com.gethealthy.searchservice.enums.HealthStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDTO {
    private Long id;
    private Long recordID;
    private Long userID;
    private String title;
    private EventType eventType;
    private String description;
    private String location;
    private String startDate;
    private HealthStatus healthStatus;
}
