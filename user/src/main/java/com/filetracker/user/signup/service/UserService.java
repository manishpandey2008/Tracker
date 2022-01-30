package com.filetracker.user.signup.service;

import com.filetracker.user.dto.ResponseDto;
import com.filetracker.user.signup.entity.User;

import java.util.List;

public interface UserService {
    public ResponseDto saveUser(User user);

    public List<User> getAllUsers();

    public List<User> getAllUsersByOrganizationCode(String organizationCode);

    public List<User> getAllUsersByDepartmentCode(String departmentCode);

    public User getUserByPhoneNumber(String phoneNumber);

    public User getUserByEmail(String email);

    public User getUserByUsername(String username);
}
