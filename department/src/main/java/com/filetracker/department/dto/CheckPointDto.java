package com.filetracker.department.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckPointDto {
    private Long checkPointId;

    private Long checkPointIndex;

    private String departmentCode;

    private Date entryDate;

    private Date exitDate;

    private String stageStatus;

    private String fileCode;
}
