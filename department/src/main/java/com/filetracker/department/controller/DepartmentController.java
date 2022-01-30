package com.filetracker.department.controller;

import com.filetracker.department.dto.DepartmentFileDto;
import com.filetracker.department.dto.ResponceDto;
import com.filetracker.department.entity.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public interface DepartmentController {

    @GetMapping("/info")
    public ResponseEntity<ResponceDto> getServiceInfo();

    @PostMapping("/")
    public ResponseEntity<ResponceDto> saveDepartment(@RequestBody Department department);

    @GetMapping("/")
    public ResponseEntity<List<Department>> getAllDepartment();

    @GetMapping("/organizationCode/{organizationCode}")
    public  ResponseEntity<List<Department>> getAllDepartmentByOrganization(@PathVariable String organizationCode);

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id);

    @GetMapping("/code/{code}")
    public ResponseEntity<DepartmentFileDto> getDepartmentByCode(@PathVariable String code);
}
