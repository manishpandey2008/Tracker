package com.filetracker.userservice;

import com.filetracker.userservice.entity.Role;
import com.filetracker.userservice.entity.User;
import com.filetracker.userservice.service.UserSerciceImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}


	@Bean
	PasswordEncoder getPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	CommandLineRunner run(UserSerciceImp userSerciceImp){
//		return args -> {
//			userSerciceImp.saveRole(new Role(null,"ROLE_ADMIN"));
//			userSerciceImp.saveUser(new User(
//					null,
//					"Balmukund Pandey",
//					"pandey123",
//					"password",
//					"pandey@gmail.com",
//					"1234567890",
//					"RTU",
//					"CSRTU",
//					"1234",
//					true,
//					null
//			));
//
//			userSerciceImp.addRoleToUser("pandey123","ROLE_ADMIN");
//		};
//	}
}
