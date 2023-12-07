package com.example.demo.src.measure.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EnvReq {
    private int machineIdx;
    private double temperature;
    private double humidity;
}
