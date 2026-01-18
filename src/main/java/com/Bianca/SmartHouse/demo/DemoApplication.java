package com.Bianca.SmartHouse.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner run(HouseRepository houseRepository,
                          UserRepository userRepository,
                          PasswordEncoder enc) {
        return args -> {

            // admin
            if (!userRepository.existsByUsername("admin")) {
                userRepository.save(new AppUser("admin", enc.encode("admin"), Role.ADMIN, null));
            }

            // users default (NU se mai dublează)
            seedUserWithHouse(userRepository, houseRepository, enc,
                    "Iacob", "pass", "Iacob's house");

            seedUserWithHouse(userRepository, houseRepository, enc,
                    "Vancea", "pass", "Vancea's house");
        };
    }

    private void seedUserWithHouse(UserRepository userRepository,
                                   HouseRepository houseRepository,
                                   PasswordEncoder enc,
                                   String username,
                                   String rawPass,
                                   String houseName) {

        // dacă user-ul există, gata
        if (userRepository.existsByUsername(username)) return;

        // casa: o găsești după nume sau o creezi
        House h = houseRepository.findByName(houseName)
                .orElseGet(() -> houseRepository.save(new House(houseName)));

        userRepository.save(new AppUser(username, enc.encode(rawPass), Role.USER, h));
    }
}
