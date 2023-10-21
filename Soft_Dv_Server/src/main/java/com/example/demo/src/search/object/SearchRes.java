package com.example.demo.src.search.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchRes {
    private int index;
    private String kind;
    private String image;
    private String scientificName;

}
