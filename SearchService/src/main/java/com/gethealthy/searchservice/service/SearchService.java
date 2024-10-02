package com.gethealthy.searchservice.service;

import com.gethealthy.searchservice.model.SearchResult;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SearchService {
    /**
     * searches both the illness records database and the events database for records matching the search term
     *
     * @param term string to search against
     * @param authorizationHeader header of the request
     * @return a list of searchResult objects
     */
    ResponseEntity<List<SearchResult>> search(String term, String authorizationHeader);

    /**
     * searches the events database for records matching the search term
     *
     * @param term string to search against
     * @param authorizationHeader header of the request
     * @return a list of searchResult objects
     */
    ResponseEntity<List<SearchResult>> searchEvent(String term, String authorizationHeader);

    /**
     * searches both the illness records database for records matching the search term
     *
     * @param term string to search against
     * @param authorizationHeader header of the request
     * @return a list of searchResult objects
     */
    ResponseEntity<List<SearchResult>> searchIllnessRecord(String term, String authorizationHeader);
}
