package com.Bianca.SmartHouse.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final HouseRepository houseRepository;
    private final UserRepository userRepository;
    private final HouseService houseService;

    public AdminController(HouseRepository houseRepository, UserRepository userRepository, HouseService houseService) {
        this.houseRepository = houseRepository;
        this.userRepository = userRepository;
        this.houseService = houseService;
    }

    @GetMapping("/houses")
    public List<House> allHouses() {
        return houseRepository.findAll();
    }

    @PostMapping("/houses")
    public House addHouse(@RequestParam String name) {
        return houseRepository.save(new House(name));
    }

    @DeleteMapping("/houses/{id}")
    public void deleteHouse(@PathVariable Long id) {
        houseRepository.deleteById(id);
    }

    @GetMapping("/users")
    public List<AppUser> users() {
        return userRepository.findAll();
    }

    @PostMapping("/users/{userId}/assign-house")
    public AppUser assignHouse(@PathVariable Long userId, @RequestParam Long houseId) {
        AppUser u = userRepository.findById(userId).orElseThrow();
        House h = houseRepository.findById(houseId).orElseThrow();
        u.setHouse(h);
        return userRepository.save(u);
    }

    @PostMapping("/houses/{id}/toggle-light")
    public House toggleLight(@PathVariable Long id) {
        return houseService.toggleLight(id);
    }

    @PostMapping("/houses/{id}/set-target-temperature")
    public House setTarget(@PathVariable Long id, @RequestParam double value) {
        return houseService.setTargetTemperature(id, value);
    }

}
