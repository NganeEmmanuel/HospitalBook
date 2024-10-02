package com.gethealthy.searchservice.service;

import com.gethealthy.searchservice.enums.SourceType;
import com.gethealthy.searchservice.model.EventDTO;
import com.gethealthy.searchservice.model.SearchResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventResultMapperService implements ResultMapperService<EventDTO> {
    @Override
    public void add(EventDTO eventDTO, List<SearchResult> searchResults) {
        var event = SearchResult.builder()
                .id(eventDTO.getId())
                .title(eventDTO.getTitle())
                .description(eventDTO.getDescription())
                .source(SourceType.EVENT)
                .eventType(eventDTO.getEventType())
                .Status(eventDTO.getHealthStatus().toString())
                .dateStarted(eventDTO.getStartDate())
                .build();

        searchResults.add(event);
    }

    @Override
    public void addAll(List<EventDTO> eventDTOS, List<SearchResult> searchResults) {
        eventDTOS.forEach(eventDTO -> add(eventDTO, searchResults));
    }
}
