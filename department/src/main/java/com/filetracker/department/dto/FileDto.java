package com.filetracker.department.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDto {
    private Long fileId;
    private String fileName;
    private String details;
    private String organizationCode;
    private String fileCode;
    private String subjectOfFile;
    private String senderId;
    private String sectionCode;
    private String fileLabel;
    private Set<CheckPointDto> checkPoints;
}
