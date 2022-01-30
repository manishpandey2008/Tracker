package com.filetracker.user.signup.controller;

import com.filetracker.user.dto.ResponseDto;
import com.filetracker.user.signup.entity.User;
import com.filetracker.user.signup.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public record UserControllerImp(UserService userService) implements UserController{

    @Override
    public ResponseEntity<ResponseDto> userServiceInfo() {
        return new ResponseEntity<>(new ResponseDto("User Service Working Fine"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> saveUser(User user) {
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<User>> getAllUsersByOrganizationCode(String organizationCode) {
        return new ResponseEntity<>(userService.getAllUsersByOrganizationCode(organizationCode),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<User>> getAllUsersByDepartmentCode(String departmentCode) {
        return new ResponseEntity<>(userService.getAllUsersByDepartmentCode(departmentCode),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> getUserByPhoneNumber(String phoneNumber) {
        return new ResponseEntity<>(userService.getUserByPhoneNumber(phoneNumber),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> getUserByEmail(String email) {
        return new ResponseEntity<>(userService.getUserByEmail(email),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> getUserByUsername(String username) {
        return new ResponseEntity<>(userService.getUserByUsername(username),HttpStatus.OK);
    }
}
