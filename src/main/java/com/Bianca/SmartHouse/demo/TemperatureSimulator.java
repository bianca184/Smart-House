package com.Bianca.SmartHouse.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TemperatureSimulator {
    private final HouseRepository houseRepository;
    private final Random random = new Random();

    public TemperatureSimulator(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Scheduled( fixedRate  =10000)

    public void updateTemperature()
    {
        var houses=houseRepository.findAll();
        for (House house : houses) {
            double temp = house.getTemperature();

            if (house.isHeatingOn()) {
                temp += 0.2;
            } else {
                temp -= 0.1;
            }


            temp = Math.round(temp * 10) / 10.0;
            house.setTemperature(temp);


            if (temp >= house.getTargetTemperature()) {
                house.setHeatingOn(false);
            }

            houseRepository.save(house);
        }

        System.out.println("Temperature simulated");
    }




}