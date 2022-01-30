package com.filetracker.department.services;

import com.filetracker.department.dto.DepartmentFileDto;
import com.filetracker.department.dto.ResponceDto;
import com.filetracker.department.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {

    public ResponceDto saveDepartment(Department department);

    public List<Department> getAllDepartment();

    public  List<Department> getAllDepartmentByOrganization(String organizationCode);

    public Department getDepartmentById(Long id);

    public DepartmentFileDto getDepartmentByCode(String code);
}
