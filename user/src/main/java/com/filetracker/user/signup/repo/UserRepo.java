package com.filetracker.user.signup.repo;

import com.filetracker.user.signup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByUserEmail(String email);

    Optional<User> findByUserPhone(String phone);

    Optional<List<User>> findByOrganizationCodeEquals(String organizationCode);

    Optional<List<User>> findByDepartmentCodeEquals(String departmentCode);
}
