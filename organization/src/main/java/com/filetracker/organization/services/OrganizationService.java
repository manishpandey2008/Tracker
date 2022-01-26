package com.filetracker.organization.services;

import com.filetracker.organization.dto.ResponceDto;
import com.filetracker.organization.entity.Organization;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrganizationService {

    public ResponceDto saveOrganization(Organization organization);

    public List<Organization> getAllOrganization();

    public Organization getOrganizationByUuid(Long id);

    public Organization getOrganizationByCode(String code);

    public List<Organization> getAllOrganizationByCountryName(String countryName);

    public List<Organization> getAllOrganizationByAreaCode(String areaCode);

}
