package com.amigo.security.service;

import com.amigo.security.entity.Role;
import com.amigo.security.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String role);
    User getUser(String username);
    List<User> getUsers();
    List<Role> getRoles();
}
