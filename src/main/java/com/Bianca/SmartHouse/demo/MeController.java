package com.Bianca.SmartHouse.demo;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/me")
public class MeController {
    private final UserRepository userRepository;
    private final HouseService houseService;

    public MeController(UserRepository userRepository, HouseService houseService) {
        this.userRepository = userRepository;
        this.houseService = houseService;
    }

    private AppUser current(Authentication auth) {
        return userRepository.findByUsername(auth.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @GetMapping("/house")
    public House myHouse(Authentication auth) {
        AppUser u = current(auth);
        if (u.getHouse() == null) throw new RuntimeException("No house assigned");
        return houseService.findById(u.getHouse().getId());
    }

    @PostMapping("/house/toggle-light")
    public House toggleLight(Authentication auth) {
        AppUser u = current(auth);
        return houseService.toggleLight(u.getHouse().getId());
    }

    @PostMapping("/house/set-target-temperature")
    public House setTarget(Authentication auth, @RequestParam double value) {
        AppUser u = current(auth);
        return houseService.setTargetTemperature(u.getHouse().getId(), value);
    }
}
