package com.example.demo.src.main.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BreedEnvRes {
    private double setTemperature;
    private double curTemperature;
    private double setMoisture;
    private double curMoisture;
}
