package com.Bianca.SmartHouse.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/houses")
public class HouseController {
    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping

    public List<House> getAllHouses() {
        return houseService.findAll();
    }

    @GetMapping("/{id}")
    public House getHouse(@PathVariable Long id) {
        return houseService.findById(id);
    }

    @PostMapping("/{id}/toggle-light")
    public House toggleLight(@PathVariable Long id) {
        return houseService.toggleLight(id);
    }

    @PostMapping("/{id}/set-target-temperature")
    public House setTargetTemperature(@PathVariable Long id, @RequestParam double value) {
        return houseService.setTargetTemperature(id, value);
    }


    @PostMapping("/{id}/set-temperature")
    public House setTemperature(@PathVariable Long id, @RequestParam double value) {
        return houseService.setTemperature(id, value);
    }

}
