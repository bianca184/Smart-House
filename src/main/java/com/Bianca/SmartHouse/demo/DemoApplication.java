package com.Bianca.SmartHouse.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(HouseRepository houseRepository, HouseService houseService) {
		return args -> {
			houseRepository.save(new House("Iacob' s house"));
			houseRepository.save(new House("Vancea' s house"));
			System.out.println(houseRepository.findAll());
		};
	}
}
