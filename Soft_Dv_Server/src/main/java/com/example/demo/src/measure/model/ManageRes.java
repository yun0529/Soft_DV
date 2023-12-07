package com.example.demo.src.measure.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ManageRes {
    private int insectIdx;
    private int groupIdx;
    private int insectInfoIdx;
    private int family;
    private String sex;
    private double weight;
    private double size;
    private double recommendTemperature;
    private double recommendMoisture;
    private String kind;
    private int adult;
    private String image;
}
