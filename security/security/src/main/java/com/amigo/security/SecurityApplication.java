package com.amigo.security;


import com.amigo.security.entity.Role;
import com.amigo.security.entity.User;
import com.amigo.security.service.UserSerciceImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}


	@Bean
	CommandLineRunner run(UserSerciceImp userSerciceImp){
		return args-> {
					userSerciceImp.saveRole(new Role(null,"ROLE_USER"));
					userSerciceImp.saveRole(new Role(null,"ROLE_MANAGER"));
					userSerciceImp.saveRole(new Role(null,"ROLE_ADMIN"));
					userSerciceImp.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

//			List<String> roles=new ArrayList<>();
//			roles.add("ROLE_USER");
//			userSerciceImp.saveUser(new User(null,"Manish Pandey","manish123","password",List.of(new Role(null,"ROLE_USER"))));
//			userSerciceImp.saveUser(new User(null,"Balmukund Pandey","bal123","password",new ArrayList<>()));
//			userSerciceImp.saveUser(new User(null,"Avinash Pandey","avi123","password",new ArrayList<>()));
			userSerciceImp.saveUser(new User(null,"Pandey Ji","pandey123","password",new ArrayList<>()));


//			userSerciceImp.addRoleToUser("manish123","ROLE_USER");
//			userSerciceImp.addRoleToUser("bal123","ROLE_ADMIN");
//			userSerciceImp.addRoleToUser("bal123","ROLE_SUPER_ADMIN");
			userSerciceImp.addRoleToUser("pandey123","ROLE_USER");
			userSerciceImp.addRoleToUser("pandey123","ROLE_ADMIN");


		};
	}

}
