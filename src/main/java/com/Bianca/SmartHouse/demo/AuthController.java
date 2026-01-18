package com.Bianca.SmartHouse.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final HouseRepository houseRepository;
    private final PasswordEncoder enc;

    public AuthController(UserRepository userRepository, HouseRepository houseRepository, PasswordEncoder enc) {
        this.userRepository = userRepository;
        this.houseRepository = houseRepository;
        this.enc = enc;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {


        String name = (req.name() == null) ? "" : req.name().trim();
        String password = (req.password() == null) ? "" : req.password().trim();

        if (name.isBlank()) return ResponseEntity.badRequest().body("name gol");
        if (password.isBlank()) return ResponseEntity.badRequest().body("password gol");


        if (userRepository.existsByUsername(name))
            return ResponseEntity.badRequest().body("Exista deja utilizatorul: " + name);

        if (houseRepository.existsByName(name))
            return ResponseEntity.badRequest().body("Exista deja casa: " + name);


        double temperature = (req.temperature() == null) ? 22.0 : req.temperature();
        double targetTemperature = (req.targetTemperature() == null) ? 22.0 : req.targetTemperature();


        if (temperature < -50 || temperature > 60)
            return ResponseEntity.badRequest().body("temperature invalid");
        if (targetTemperature < 5 || targetTemperature > 35)
            return ResponseEntity.badRequest().body("targetTemperature invalid");


        House h = new House(name);
        h.setTemperature(temperature);
        h.setTargetTemperature(targetTemperature);
        h.setHeatingOn(temperature < targetTemperature);

        h = houseRepository.save(h);


        AppUser u = new AppUser(name, enc.encode(password), Role.USER, h);
        userRepository.save(u);

        return ResponseEntity.ok("OK");
    }
}
