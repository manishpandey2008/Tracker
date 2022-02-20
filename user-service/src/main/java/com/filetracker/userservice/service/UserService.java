package com.filetracker.userservice.service;

import com.filetracker.userservice.entity.Role;
import com.filetracker.userservice.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username,String role);

    User getUser(String username);

    List<User> getUsers();

    List<Role> getRoles();

    List<User> getAllUsersByOrganizationCode(String organizationCode);

    List<User> getAllUsersByDepartmentCode(String departmentCode);

    User getUserByPhoneNumber(String phoneNumber);

    User getUserByEmail(String email);

}
