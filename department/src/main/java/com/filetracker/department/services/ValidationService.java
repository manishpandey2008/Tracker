package com.filetracker.department.services;

import com.filetracker.department.entity.Department;
import com.filetracker.department.repo.DepartmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public record ValidationService(DepartmentRepo departmentRepo) {
    public boolean checkDepartmentId(Department department) {
        Department tempDepartment = departmentRepo.findByDepartmentCode(department.getDepartmentCode()).orElse(null);
        if (tempDepartment != null && department.getDepartmentId()==null) {
            if (tempDepartment.getOrganizationCode().equals(department.getOrganizationCode())) {
                return false;
            }
        }
        return true;
    }
}
