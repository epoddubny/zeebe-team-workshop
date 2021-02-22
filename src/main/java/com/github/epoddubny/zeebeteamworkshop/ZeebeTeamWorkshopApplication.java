package com.github.epoddubny.zeebeteamworkshop;

import io.zeebe.spring.client.EnableZeebeClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableZeebeClient
public class ZeebeTeamWorkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeebeTeamWorkshopApplication.class, args);
	}

}
