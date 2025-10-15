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
}
