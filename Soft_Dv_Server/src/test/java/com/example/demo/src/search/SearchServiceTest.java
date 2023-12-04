package com.example.demo.src.search;

import com.example.demo.src._method.InnerMethod;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceTest {
/**
 * 작성자 : 이정현
 * 설명 :
 *      이 클래스는 SearchService 클래스의 단위테스트를 위한 작업 공간입니다.
 *      구현된 메서드 / 내용 : 
 *                        1. search() / 정확도, 시간
 * */

    @Test
    //search에서 호출하는 _divideIntoWords()의 작업 시간 테스트 - 목표 : 0.200s
    void search() {
        // 테스트 할 단어를 선정하였다. (노래 가사 - 플라워 '눈물')
        // 여러번 등장하는 단어에는 숫자를 붙여 구분하였다.
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
        // testWords를 한 문장으로 만든다.
        // 이는 원본 함수의 input과 같은 역할이다.
        String testWord = "";
        for(String s : testWords) {
            testWord += s + " ";
        }
        // InnerMethod 클래스의 _devideIntoWords 메서드를 이용해 한 문장으로 구성된 것을 단어 단위로 구분하였다.
        // 그것을 testWords와 비교한다.
        ArrayList<String> words = new InnerMethod()._divideIntoWords(testWord);
        for(String s : words) {
            assertEquals(s, testWords[words.indexOf(s)]);
        }
    }

    @Test
    // SearchService의 search의 _divideIntoWords()메서드가 실행되는 시간과
    // DB에서 검색하여 결과를 도출할 때까지의 시간을 합한 것을 기록한다. 목표 : 0.500s
    void search2() {
        // 테스트 할 단어를 선정하였다.
        // 이 단어들은 실제로 검색 API에 입력될 것이다.
        String[] testWords = {"dor","tor","por","kor","뺚","삡","쁍"};
        // testWords를 한 문장으로 만든다.
        // 이는 원본 함수의 input과 같은 역할이다.
        String testWord = "";
        for(String s : testWords) {
            testWord += s + " ";
        }
        // InnerMethod 클래스의 _devideIntoWords 메서드를 이용해 한 문장으로 구성된 것을 단어 단위로 구분하였다.
        // 그것을 testWords와 비교한다.
        ArrayList<String> words = new InnerMethod()._divideIntoWords(testWord);
        for(String s : words) {
            assertEquals(s, testWords[words.indexOf(s)]);
        }
    }
}