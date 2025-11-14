package com.Bianca.SmartHouse.demo;


import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HouseService {
    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public House savePlayer(House house) {
        return houseRepository.save(house);
    }

    public List<House> findAll() {
        return houseRepository.findAll();
    }

    public House findById(long id) {
        return houseRepository.findById(id).orElseThrow(()-> new RuntimeException("House not found"));
    }

    public House toggleLight(Long id) {
        House house = findById(id);
        house.setLightOn(!house.isLightOn());
        return houseRepository.save(house);
    }

    public House setTargetTemperature(Long id, double value) {
        House house = findById(id);
        house.setTargetTemperature(value);


        house.setHeatingOn(house.getTemperature() < value);

        return houseRepository.save(house);
    }


    public House setTemperature(Long id, double value) {
        House house = findById(id);
        house.setTemperature(value);
        return houseRepository.save(house);
    }

}
