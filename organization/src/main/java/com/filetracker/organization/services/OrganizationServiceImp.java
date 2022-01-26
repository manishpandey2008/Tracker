package com.filetracker.organization.services;

import com.filetracker.organization.dto.ResponceDto;
import com.filetracker.organization.entity.Organization;
import com.filetracker.organization.repo.OrganizationRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public record OrganizationServiceImp(OrganizationRepo organizationRepo) implements OrganizationService {

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
    public Organization getOrganizationByUuid(Long id) {
        log.info("Get organization which Id is: "+id+" : Service");
        try {
            Organization allOrganization=organizationRepo.findById(id).orElse(null);
            return allOrganization;
        }catch (Exception e){
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public Organization getOrganizationByCode(String code) {
        log.info("Get organization which Organization Code is: "+code+" : Service");
        try {
            Organization allOrganization=organizationRepo.findByOrganizationCode(code).orElse(null);
            return allOrganization;
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
}
