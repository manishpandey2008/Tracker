package com.filetracker.user.signup.service;

import com.filetracker.user.dto.ResponseDto;
import com.filetracker.user.signup.entity.User;
import com.filetracker.user.signup.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public record UserServiceImp(UserRepo userRepo,
                             EmailService emailService,
                             UserValidation userValidation) implements UserService {

    @Override
    public ResponseDto saveUser(User user) {

        try {
            if(user.getUserId()==null){
                if(userValidation.isValidUser(user)!=null){
                    return new ResponseDto(userValidation.isValidUser(user));
                }
            }
            if(!user.isActiveStatus()){
                user.setUsername(RandomStringUtils.randomAlphanumeric(10));
                user.setUsername(RandomStringUtils.randomAlphanumeric(10));
                user.setActivateCode(RandomStringUtils.randomAlphanumeric(10));
            }
            userRepo.save(user);
            if(!user.isActiveStatus()) {
                new Thread() {
                    public void run() {
                        emailService.sendMailToUser("mpandeyji2018@gmail.com",
                                user.getUserEmail(),
                                user.getUserFullName()+":-This mail for testing purpose","Spring Testing");
                    }
                };
            }
            return new ResponseDto("User "+user.getUserFullName()+" save in data base");

        }catch(Exception e){
            log.info(e.getMessage());
            return new ResponseDto(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return userRepo.findAll();
        }catch(Exception e){
            log.info(e.getMessage());
            return null;
        }
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

    @Override
    public User getUserByUsername(String username) {
        try {
            return userRepo.findByUsername(username).orElse(null);
        }catch(Exception e){
            log.info(e.getMessage());
            return null;
        }
    }
}
