package com.filetracker.organization.dto;

import com.filetracker.organization.entity.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CombinedResponceDto {
    private Organization organization;
    private List<DepartmentDto> departmentDto;
}
