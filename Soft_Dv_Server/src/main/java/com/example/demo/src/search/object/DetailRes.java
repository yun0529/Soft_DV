package com.example.demo.src.search.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetailRes {
    private int insectInfoIdx;
    private String scientificName;
    private String kind;
    private double sizeMax;
    private String lifeCycle;
    private String image;
    private String location;
    private String breedTip;
}
