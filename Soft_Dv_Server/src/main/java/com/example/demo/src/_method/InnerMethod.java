package com.example.demo.src._method;

import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
public class InnerMethod {
    public ArrayList<String> _divideIntoWords(String input){
        ArrayList<String> result = new ArrayList<>();
        String temp = "";
        for(int i = 0; i<input.length();i++){
            if(input.charAt(i) == ' ') {
                result.add(temp);
                temp = "";
                continue;
            }
            temp += ""+input.charAt(i);
        }
        return result;
    }
}
