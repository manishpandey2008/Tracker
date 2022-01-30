package com.filetracker.filedup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FileDupApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileDupApplication.class, args);
		System.out.println("============================This is duplicate File ============================");
	}

}
