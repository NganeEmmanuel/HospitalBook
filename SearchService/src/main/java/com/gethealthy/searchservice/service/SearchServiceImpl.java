package com.gethealthy.searchservice.service;

import com.gethealthy.searchservice.feign.EventInterface;
import com.gethealthy.searchservice.feign.IllnessRecordInterface;
import com.gethealthy.searchservice.model.EventDTO;
import com.gethealthy.searchservice.model.IllnessRecordDTO;
import com.gethealthy.searchservice.model.SearchResult;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final EventInterface eventInterface;
    private final IllnessRecordInterface illnessRecordInterface;
    private final ResultMapperService<EventDTO> eventResultMapperService;
    private final ResultMapperService<IllnessRecordDTO> illnessRecordResultMapperService;
    private static final Logger logger = LoggerFactory.getLogger(SearchService.class);

    @Override
    public ResponseEntity<List<SearchResult>> search(String term, String authorizationHeader) {
        var searchResults = new ArrayList<SearchResult>();
        try {
            //make call to event and illnessRecord services using feign interface
            var events = eventInterface.searchEvents(term, authorizationHeader).getBody();
            var illnessRecords = illnessRecordInterface.SearchRecords(term, authorizationHeader).getBody();

            //check for not null return values
            assert events != null && illnessRecords != null;
            //check for empty results list
            if (events.isEmpty() && illnessRecords.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            //add event and illnessRecord to search result list
            eventResultMapperService.addAll(events, searchResults);
            illnessRecordResultMapperService.addAll(illnessRecords, searchResults);

            return ResponseEntity.ok(searchResults.stream().sorted().toList()); //todo check for returning a shuffled list
        }catch (Exception e){
            logger.info("Something went wrong while trying to search events and illness records with term: {}", term);
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public ResponseEntity<List<SearchResult>> searchEvent(String term, String authorizationHeader) {
        var searchResults = new ArrayList<SearchResult>();
        try {
            //make call to the event service via feign client
            var events = eventInterface.searchEvents(term, authorizationHeader).getBody();

            //check for null response value
            assert events != null;

            //check for empty result list
            if (events.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            //add event to search result list
            eventResultMapperService.addAll(events, searchResults);

            return ResponseEntity.ok(searchResults.stream().sorted().toList());
        }catch (Exception e){
            logger.info("Something went wrong while trying to search events with term: {}", term);
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public ResponseEntity<List<SearchResult>> searchIllnessRecord(String term, String authorizationHeader) {
        var searchResults = new ArrayList<SearchResult>();
        try{
            //make call to the illness record service
            var illnessRecords = illnessRecordInterface.SearchRecords(term, authorizationHeader).getBody();

            //check for null response value
            assert illnessRecords != null;
            //check for empty result list
            if(illnessRecords.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            //add illness records to search result list
            illnessRecordResultMapperService.addAll(illnessRecords, searchResults);

            return ResponseEntity.ok(searchResults.stream().sorted().toList());
        }catch (Exception e){
            logger.info("Something went wrong while trying to search illness records with term: {}", term);
            return ResponseEntity.noContent().build();
        }
    }
}
