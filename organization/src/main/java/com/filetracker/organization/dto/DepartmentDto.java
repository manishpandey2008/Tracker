package com.filetracker.organization.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long departmentId;
    private String departmentName;
    private String organizationCode;
    private String departmentCode;
    private String phoneNumber;
    private String email;
    private String details;
    private String[] openDays;
    private String openTime;
    private String closeTime;
    private String createdBy;
    private String updatedBy;
    private Date createdTimestamp;
    private Date updatedTimestamp;
}
