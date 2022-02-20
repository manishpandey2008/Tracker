package com.filetracker.userservice.api;

import com.filetracker.userservice.dto.RollToUser;
import com.filetracker.userservice.entity.Role;
import com.filetracker.userservice.entity.User;
import com.filetracker.userservice.service.UserSerciceImp;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserSerciceImp userSerciceImp;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userSerciceImp.getUsers());
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles(){
        return ResponseEntity.ok().body(userSerciceImp.getRoles());
    }

    @PostMapping("/new")
    public ResponseEntity<User> addUser(@RequestBody User user){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/").toUriString());
        return ResponseEntity.created(uri).body(userSerciceImp.saveUser(user));
    }

    @GetMapping("{username}")
    public ResponseEntity<User> getlUser(@PathVariable String username){
        return ResponseEntity.ok().body(userSerciceImp.getUser(username));
    }

    @PostMapping("/role")
    public ResponseEntity<Role> addRole(@RequestBody  Role role){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/").toUriString());
        return ResponseEntity.created(uri).body(userSerciceImp.saveRole(role));
    }

    @PostMapping("/roletouser")
    public ResponseEntity<?> addRoleForUser(@RequestBody RollToUser rollToUser){
        System.out.println("===================================");
        System.out.println(rollToUser.getUsername());
        System.out.println(rollToUser.getRollName());
        userSerciceImp.addRoleToUser(rollToUser.getUsername(),rollToUser.getRollName());
        return null;
    }

    @GetMapping("/organizationCode/{organizationCode}")
    public ResponseEntity<List<User>> getAllUsersByOrganizationCode(@PathVariable String organizationCode){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/organizationCode/"+organizationCode).toUriString());
        return ResponseEntity.created(uri).body(userSerciceImp.getAllUsersByOrganizationCode(organizationCode));
    }

    @GetMapping("/departmentCode/{departmentCode}")
    public ResponseEntity<List<User>> getAllUsersByDepartmentCode(String departmentCode){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/departmentCode/"+departmentCode).toUriString());
        return ResponseEntity.created(uri).body(userSerciceImp.getAllUsersByDepartmentCode(departmentCode));
    }

    @GetMapping("/phoneNumber/{phoneNumber}")
    public ResponseEntity<User> getUserByPhoneNumber(String phoneNumber){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/phoneNumber/"+phoneNumber).toUriString());
        return ResponseEntity.created(uri).body(userSerciceImp.getUserByPhoneNumber(phoneNumber));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(String email){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/email/"+email).toUriString());
        return ResponseEntity.created(uri).body(userSerciceImp.getUserByEmail(email));
    }




}
