package com.gethealthy.searchservice.service;

import com.gethealthy.searchservice.enums.SourceType;
import com.gethealthy.searchservice.model.IllnessRecordDTO;
import com.gethealthy.searchservice.model.SearchResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IllnessRecordResultMapperService implements ResultMapperService<IllnessRecordDTO> {
    @Override
    public void add(IllnessRecordDTO illnessRecordDTO, List<SearchResult> searchResults) {
        var illnessRecord = SearchResult.builder()
                .id(illnessRecordDTO.getId())
                .title(illnessRecordDTO.getIllnessName())
                .description(illnessRecordDTO.getIllnessDescription())
                .source(SourceType.ILLNESS_RECORD)
                .Status(illnessRecordDTO.getIllnessStatus().toString())
                .dateStarted(illnessRecordDTO.getIllnessStartDate())
                .build();

        searchResults.add(illnessRecord);
    }

    @Override
    public void addAll(List<IllnessRecordDTO> illnessRecordDTOS, List<SearchResult> searchResults) {
        illnessRecordDTOS.forEach(illnessRecordDTO -> add(illnessRecordDTO, searchResults));
    }
}
