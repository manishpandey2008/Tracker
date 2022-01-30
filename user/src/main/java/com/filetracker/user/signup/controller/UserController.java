package com.filetracker.user.signup.controller;

import com.filetracker.user.dto.ResponseDto;
import com.filetracker.user.signup.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public interface UserController {

    @GetMapping("/info")
    public ResponseEntity<ResponseDto> userServiceInfo();

    @PostMapping("/")
    public ResponseEntity<ResponseDto> saveUser(@RequestBody User user);

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers();

    @GetMapping("/organizationCode/{organizationCode}")
    public ResponseEntity<List<User>> getAllUsersByOrganizationCode(@PathVariable String organizationCode);

    @GetMapping("/departmentCode/{departmentCode}")
    public ResponseEntity<List<User>> getAllUsersByDepartmentCode(@PathVariable String departmentCode);

    @GetMapping("/phoneNumber/{phoneNumber}")
    public ResponseEntity<User> getUserByPhoneNumber(@PathVariable String phoneNumber);

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email);

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username);
}
