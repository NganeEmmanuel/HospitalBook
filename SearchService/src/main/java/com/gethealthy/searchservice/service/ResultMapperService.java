package com.gethealthy.searchservice.service;

import com.gethealthy.searchservice.model.SearchResult;

import java.util.List;

/**
 *
 * @param <T> result entity object (e.g., Events, IllnessRecord)
 */
public interface ResultMapperService<T> {
    /**
     * Add an object to the search result list of the
     *
     * @param t Object containing the information
     * @param searchResults The list to add the information to
     */
    void add(T t, List<SearchResult> searchResults);

    /**
     * Add all object to the search result list of the
     *
     * @param ts List of Object containing the information
     * @param searchResults The list to add the information to
     */
    void addAll(List<T> ts, List<SearchResult> searchResults);
}
