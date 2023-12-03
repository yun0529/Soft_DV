package com.example.demo.src.search;

import com.example.demo.src._method.InnerMethod;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceTest {

    @Test
    void search() {
        String[] testWords = {"수줍게","고백","못하고","그저","널","바라만","보았지"+
                "넌","이미","친구의","연인이되어","가질","수","없는","사랑을"+
                "아쉬운","마음","달래고","몰래","눈물","감춰","보았어","용기가"+
                "없었던","초라한","모습","난","이미2","늦은","후회뿐"+
                "어느새","네게","다가온","이별","그","슬픔을","알게","된거야"+
                "하지만","이젠","널2","위한","위로가","나는","될","수2","없는데"+
                "널3","울도록","그냥","내버려","둘꺼야"+
                "시간속으로","희미해","지겠지"+
                "언젠가는","슬픈","기억도","아픔도"+
                "네게","스스로","위로가2","될테니까"};
        String testWord = "";
        for(String s : testWords) {
            testWord += s + " ";
        }

        ArrayList<String> words = new InnerMethod()._divideIntoWords(testWord);
        for(String s : words) {
            assertEquals(s, testWords[words.indexOf(s)]);
        }
    }
}