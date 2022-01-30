package com.filetracker.department.services;

import com.filetracker.department.dto.DepartmentFileDto;
import com.filetracker.department.dto.FileDto;
import com.filetracker.department.dto.ResponceDto;
import com.filetracker.department.entity.Department;
import com.filetracker.department.repo.DepartmentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public record DepartmentServiceImp(DepartmentRepo departmentRepo,
                                   ValidationService validationService,
                                   RestTemplate restTemplate) implements DepartmentService {

    @Override
    public ResponceDto saveDepartment(Department department) {
        log.info(department.getDepartmentName()+" in process for save in database :Service");
        try{
            if(validationService.checkDepartmentId(department)){
                departmentRepo.save(department);
                return new ResponceDto(department.getDepartmentName() +" save in database");
            }
            return new ResponceDto(department.getDepartmentName() +
                    " not save in database because your department id "+department.getDepartmentId()+
                    "already available in this organization ");
        }catch (Exception e){
            log.info(e.getMessage());
            return new ResponceDto(e.getMessage());
        }
    }

    @Override
    public List<Department> getAllDepartment() {
        log.info("get all department from database :Service");
        try{
            List<Department> tempDepartment=departmentRepo.findAll();
            return tempDepartment;
        }catch (Exception e){
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Department> getAllDepartmentByOrganization(String organizationCode) {
        log.info("get all department from database by organization Code:Service");
        try{
            List<Department> tempDepartment=departmentRepo.findByOrganizationCodeEquals(organizationCode).orElse(null);
            return tempDepartment;
        }catch (Exception e){
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public Department getDepartmentById(Long id) {
        log.info("get department from database by department id:Service");
        try{
            Department tempDepartment=departmentRepo.findById(id).orElse(null);
            return tempDepartment;
        }catch (Exception e){
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public DepartmentFileDto getDepartmentByCode(String code) {
        log.info("get department from database by department Code:Service");
        try{
            Department tempDepartment=departmentRepo.findByDepartmentCode(code).orElse(null);
            FileDto[] files=restTemplate.getForObject("http://file-service/api/file/departmentCode/MEMCK",FileDto[].class);
            DepartmentFileDto departmentFileDto=new DepartmentFileDto();
            departmentFileDto.setDepartment(tempDepartment);
            departmentFileDto.setFiles(List.of(files));
            return departmentFileDto;
        }catch (Exception e){
            log.info(e.getMessage());
            return null;
        }
    }
}
