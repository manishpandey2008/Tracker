package com.filetracker.organization.repo;

import com.filetracker.organization.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationRepo extends JpaRepository<Organization, Long> {

    Optional<Organization> findByOrganizationCode(String code);

    //@Query("select u from organization u where u.country_name = :country")
    Optional<List<Organization>> findByCountryNameEquals(String country);

    Optional<List<Organization>> findByAreaPinCodeEquals(String areaPinCode);


}
