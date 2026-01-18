package com.Bianca.SmartHouse.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "houses")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private boolean lightOn;
    private double temperature;
    private boolean heatingOn;
    private double targetTemperature;


    public House() {}

    public House(String name) {
        this.name = name;
        this.lightOn = false;
        this.temperature = 22;
        this.heatingOn = false;
        this.targetTemperature = 22;
    }

    public boolean isHeatingOn() {
        return heatingOn;
    }

    public void setHeatingOn(boolean heatingOn) {
        this.heatingOn = heatingOn;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public boolean isLightOn() {
        return lightOn;
    }

    public void setLightOn(boolean lightOn) {
        this.lightOn = lightOn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTargetTemperature()
    {
        return targetTemperature; }
    public void setTargetTemperature(double targetTemperature)
    { this.targetTemperature = targetTemperature; }


    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", name='" + name + '\'' + ", lightOn=" + lightOn + ", temperature=" + temperature + ", heatingOn=" + heatingOn +
                '}';
    }
}
