package com.example.abnerlucss.msvvalidationboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsvValidationBoardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvValidationBoardingApplication.class, args);
	}

}
