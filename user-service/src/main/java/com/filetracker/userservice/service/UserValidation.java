package com.filetracker.userservice.service;

import com.filetracker.userservice.entity.User;
import com.filetracker.userservice.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public record UserValidation(UserRepo userRepo) {

    public String isValidUser(User user) {
        if(userRepo.findByUsername(user.getUsername())!=null){
            return "Username "+user.getUsername()+" Already registered in database.Please try with any other username !! Thank You";
        }
        if(userRepo.findByUserPhone(user.getUserPhone()).orElse(null)!=null){
            return "Phone Number "+user.getUserPhone()+" Already registered in database.Please try with any other phone number !! Thank You";
        }
        if(userRepo.findByUserEmail(user.getUserEmail()).orElse(null)!=null){
            return "Email id "+user.getUserEmail()+" Already registered in database.Please try with any other Email Id !! Thank You";
        }
        return null;
    }
}
