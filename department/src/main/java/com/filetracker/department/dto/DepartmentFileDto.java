package com.filetracker.department.dto;

import com.filetracker.department.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentFileDto {
    private Department department;
    private List<FileDto> files;
}
