package com.filetracker.organization.controller;

import com.filetracker.organization.dto.ResponceDto;
import com.filetracker.organization.entity.Organization;
import com.filetracker.organization.services.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/organization")
@Slf4j
public record OrganizationControllerImp(OrganizationService organizationService) implements OrganizationController{


    @Override
    public ResponseEntity<String> getInfo() {
        return new ResponseEntity<>("Orgnization Service Working Fine", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponceDto> saveOrganization(Organization organization) {
        log.info("organization data present in controller for add in database");
        return new ResponseEntity<>(organizationService.saveOrganization(organization),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Organization>> getAllOrganization() {
        log.info("This api work for get all organization from database : Controller");
        return new ResponseEntity<>(organizationService.getAllOrganization(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Organization> getOrganizationByUuid(Long id) {
        log.info("Get organization which Id is: "+id);
        return new ResponseEntity<>(organizationService.getOrganizationByUuid(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Organization> getOrganizationByCode(String code) {
        log.info("Get organization which Organization Code is: "+code);
        return new ResponseEntity<>(organizationService.getOrganizationByCode(code),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Organization>> getAllOrganizationByCountryName(String countryName) {
        log.info("Get all organizations in country "+countryName);
        return new ResponseEntity<>(organizationService.getAllOrganizationByCountryName(countryName),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Organization>> getAllOrganizationByAreaCode(String areaCode) {
        log.info("Get all organizations in pin code "+areaCode);
        return new ResponseEntity<>(organizationService.getAllOrganizationByAreaCode(areaCode),HttpStatus.OK);
    }
}
