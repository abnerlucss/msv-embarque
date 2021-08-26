package com.example.abnerlucss.msvembarque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsvEmbarqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvEmbarqueApplication.class, args);
	}

}
