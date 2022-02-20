package com.filetracker.userservice.service;

import com.filetracker.userservice.entity.Role;
import com.filetracker.userservice.entity.User;
import com.filetracker.userservice.repo.RoleRepo;
import com.filetracker.userservice.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserSerciceImp implements UserService, UserDetailsService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findByUsername(username);
        if(user==null){
            log.error("Uase {} not found in database",username);
            throw new UsernameNotFoundException("Uase not found in database");
        }else{
            log.info("Uase found in database:{}",username);
        }
        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
        user.getRoles().forEach(e->{
            authorities.add(new SimpleGrantedAuthority(e.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

    @Override
    public User saveUser(User user) {
        log.info("Add new user successfully");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try{
            System.out.println(user);
            return userRepo.save(user);
        }catch (RuntimeException e){
            log.info((e.getMessage()));
            return null;
        }
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Add new role successfully");
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Add {} role to {] user successfully",roleName,username);
        User user=userRepo.findByUsername(username);
        Role role=roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Get user {} by username",username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Get All users");
        return userRepo.findAll();
    }

    @Override
    public List<Role> getRoles() {
       log.info("Fetching all roles");
       return roleRepo.findAll();
    }

    @Override
    public List<User> getAllUsersByOrganizationCode(String organizationCode) {
        try {
            return userRepo.findByOrganizationCodeEquals(organizationCode).orElse(null);
        }catch(Exception e){
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public List<User> getAllUsersByDepartmentCode(String departmentCode) {
        try {
            return userRepo.findByDepartmentCodeEquals(departmentCode).orElse(null);
        }catch(Exception e){
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        try {
            return userRepo.findByUserPhone(phoneNumber).orElse(null);
        }catch(Exception e){
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        try {
            return userRepo.findByUserEmail(email).orElse(null);
        }catch(Exception e){
            log.info(e.getMessage());
            return null;
        }
    }

}
