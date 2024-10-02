package com.gethealthy.searchservice.model;

import com.gethealthy.searchservice.enums.IllnessStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IllnessRecordDTO {
    private Long id;
    private String illnessName;
    private String illnessStartDate;
    private String illnessEndDate;
    private String illnessDescription;
    private IllnessStatus illnessStatus;
    private String illnessLocation;
}
