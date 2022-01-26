package com.filetracker.department.repo;

import com.filetracker.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {

    Optional<Department> findByDepartmentCode(String code);
    Optional<List<Department>> findByOrganizationCodeEquals(String organizationCode);

}
