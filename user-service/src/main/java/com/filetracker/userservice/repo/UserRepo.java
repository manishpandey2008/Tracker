package com.filetracker.userservice.repo;

import com.filetracker.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);

    Optional<User> findByUserPhone(String phone);

    Optional<User> findByUserEmail(String email);

    Optional<List<User>> findByOrganizationCodeEquals(String organizationCode);

    Optional<List<User>> findByDepartmentCodeEquals(String departmentCode);
}
