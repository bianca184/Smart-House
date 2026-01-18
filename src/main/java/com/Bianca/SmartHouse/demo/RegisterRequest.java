package com.Bianca.SmartHouse.demo;

public record RegisterRequest(
        String name,
        String password,
        Double temperature,
        Double targetTemperature
) {}
