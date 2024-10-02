package com.gethealthy.searchservice.model;

import com.gethealthy.searchservice.enums.EventType;
import com.gethealthy.searchservice.enums.SourceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SearchResult implements Comparable<SearchResult> {
    private Long id;
    private String title; //title of event or illness record (common property)
    private String description; //description of event or illness record (common property)
    private String Status; //either the illness record status(started, ended) or the health status of the event
    private String dateStarted; // started date (common property)
    private SourceType source;  //from events or illness record services
    private EventType eventType; //if result is from the event service and what kind of event (Symptoms, hospital visit, medication administration)

    @Override
    public int compareTo(SearchResult o) {
        return this.id.compareTo(o.id);
    }

    //todo add pagination to search
}
