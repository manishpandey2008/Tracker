package com.filetracker.department.controller;

import com.filetracker.department.dto.ResponceDto;
import com.filetracker.department.entity.Department;
import com.filetracker.department.services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@Slf4j
public record DepartmentControllerImp(DepartmentService departmentService) implements DepartmentController{


    @Override
    public ResponseEntity<ResponceDto> getServiceInfo() {
        return new ResponseEntity<>(new ResponceDto("Department Service working fine"),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponceDto> saveDepartment(Department department) {
        log.info("New Department data in develop for save");
        return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Department>> getAllDepartment() {
        log.info("Get all department :Controller");
        return new ResponseEntity<>(departmentService.getAllDepartment(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Department>> getAllDepartmentByOrganization(String organizationCode) {
        log.info("Get all department by organization Code "+organizationCode+" :Controller");
        return new ResponseEntity<>(departmentService.getAllDepartmentByOrganization(organizationCode), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Department> getDepartmentById(Long id) {
        log.info("Get department by department id "+id+" :Controller");
        return new ResponseEntity<>(departmentService.getDepartmentById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Department> getDepartmentByCode(String code) {
        log.info("Get department by department code "+code+" :Controller");
        return new ResponseEntity<>(departmentService.getDepartmentByCode(code), HttpStatus.OK);
    }
}
