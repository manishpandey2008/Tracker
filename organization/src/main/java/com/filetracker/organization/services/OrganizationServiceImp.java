package com.filetracker.organization.services;

import com.filetracker.organization.dto.CombinedResponceDto;
import com.filetracker.organization.dto.DepartmentDto;
import com.filetracker.organization.dto.ResponceDto;
import com.filetracker.organization.entity.Organization;
import com.filetracker.organization.repo.OrganizationRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public record OrganizationServiceImp(OrganizationRepo organizationRepo, RestTemplate restTemplate) implements OrganizationService {

    @Override
    public ResponceDto saveOrganization(Organization organization) {
        log.info("organization data present in service for add in database");
        try {
            Organization tempOrganization=organizationRepo.save(organization);
            return new ResponceDto(organization.getOrganizationName() +" has saved in database");
        }catch (Exception e){
            log.info(e.getMessage());
            return new ResponceDto(e.getMessage());
        }
    }

    @Override
    public List<Organization> getAllOrganization() {
        log.info("This api work for get all organization from database : Service");
        try {
            List<Organization> allOrganization=organizationRepo.findAll();
            return allOrganization;
        }catch (Exception e){
            log.info(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public CombinedResponceDto getOrganizationByUuid(Long id) {
        log.info("Get organization which Id is: "+id+" : Service");
        try {
            Organization tempOrganization=organizationRepo.findById(id).orElse(null);
            CombinedResponceDto combinedResponceDto=new CombinedResponceDto();
           if(tempOrganization!=null){
               List<DepartmentDto>  departmentDtos= List.of(this.getListOfDepartment(tempOrganization.getOrganizationCode()));
               combinedResponceDto.setOrganization(tempOrganization);
               combinedResponceDto.setDepartmentDto(departmentDtos);
           }
            return combinedResponceDto;
        }catch (Exception e){
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public CombinedResponceDto getOrganizationByCode(String code) {
        log.info("Get organization which Organization Code is: "+code+" : Service");
        try {
            Organization tempOrganization=organizationRepo.findByOrganizationCode(code).orElse(null);
            CombinedResponceDto combinedResponceDto=new CombinedResponceDto();
            if(tempOrganization!=null){
                List<DepartmentDto>  departmentDtos= List.of(this.getListOfDepartment(code));
                combinedResponceDto.setOrganization(tempOrganization);
                combinedResponceDto.setDepartmentDto(departmentDtos);
            }
            return combinedResponceDto;
        }catch (Exception e){
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Organization> getAllOrganizationByCountryName(String countryName) {
        log.info("Get all organizations which Country name is: "+countryName+" : Service");
        try {
            List<Organization> allOrganization=organizationRepo.findByCountryNameEquals(countryName).orElse(new ArrayList<>());
            return allOrganization;
        }catch (Exception e){
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Organization> getAllOrganizationByAreaCode(String areaCode) {
        log.info("Get all organizations which PIN CODE is: "+areaCode+" : Service");
        try {
            List<Organization> allOrganization=organizationRepo.findByAreaPinCodeEquals(areaCode).orElse(new ArrayList<>());
            return allOrganization;
        }catch (Exception e){
            log.info(e.getMessage());
            return null;
        }
    }

    public DepartmentDto[] getListOfDepartment(String organizationCode){
        return restTemplate.getForObject("http://DEPARTMENT-SERVICE/api/department/organizationCode/"+organizationCode,DepartmentDto[].class);
    }
}
