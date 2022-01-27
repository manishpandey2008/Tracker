package com.filetracker.organization.controller;

import com.filetracker.organization.dto.CombinedResponceDto;
import com.filetracker.organization.dto.ResponceDto;
import com.filetracker.organization.entity.Organization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/organization")
public interface OrganizationController {

    @GetMapping("/info")
    public ResponseEntity<String> getInfo();

    @PostMapping("/")
    public ResponseEntity<ResponceDto> saveOrganization(@RequestBody Organization organization);

    @GetMapping("/")
    public ResponseEntity<List<Organization>> getAllOrganization();

    @GetMapping("/{id}")
    public ResponseEntity<CombinedResponceDto> getOrganizationByUuid(@PathVariable Long id);

    @GetMapping("/code/{code}")
    public ResponseEntity<CombinedResponceDto> getOrganizationByCode(@PathVariable String code);

    @GetMapping("/country/{countryName}")
    public ResponseEntity<List<Organization>> getAllOrganizationByCountryName(@PathVariable String countryName);

    @GetMapping("/areaCode/{areaCode}")
    public ResponseEntity<List<Organization>> getAllOrganizationByAreaCode(@PathVariable String areaCode);

}
