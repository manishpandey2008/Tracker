package com.amigo.security.api;

import com.amigo.security.entity.Role;
import com.amigo.security.entity.User;
import com.amigo.security.service.UserSerciceImp;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class UserController {
    private final UserSerciceImp userSerciceImp;

    @GetMapping("user")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userSerciceImp.getUsers());
    }

    @GetMapping("roles")
    public ResponseEntity<List<Role>> getAllRoles(){
        return ResponseEntity.ok().body(userSerciceImp.getRoles());
    }

    @PostMapping("signup")
    public ResponseEntity<User> addUser(@RequestBody User user){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/").toUriString());
        return ResponseEntity.created(uri).body(userSerciceImp.saveUser(user));
    }

    @GetMapping("user/{username}")
    public ResponseEntity<User> getlUser(@PathVariable String username){
        return ResponseEntity.ok().body(userSerciceImp.getUser(username));
    }

    @PostMapping("role")
    public ResponseEntity<Role> addRole(@RequestBody  Role role){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/").toUriString());
        return ResponseEntity.created(uri).body(userSerciceImp.saveRole(role));
    }

    @PostMapping("roletouser")
    public ResponseEntity<?> addRoleForUser(@RequestBody  RollToUser rollToUser){
        userSerciceImp.addRoleToUser(rollToUser.getUsername(),rollToUser.getRollName());
        return ResponseEntity.ok().build();
    }


    @Data
    class RollToUser{
        private String username;
        private String rollName;
    }


}
