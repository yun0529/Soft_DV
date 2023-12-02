package com.example.demo.src.search;

import com.example.demo.config.BaseException;
import com.example.demo.src._method.InnerMethod;
import com.example.demo.src.search.object.DetailRes;
import com.example.demo.src.search.object.SearchRes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//
@Service
public class SearchService {

    private final SearchDAO searchDAO;
    private InnerMethod m = new InnerMethod();
    public SearchService(SearchDAO searchDAO){
        this.searchDAO = searchDAO;
    }

    public ArrayList<SearchRes> search(String input) throws BaseException {
        ArrayList<String> words = m._divideIntoWords(input);
        return this.searchDAO.search(words);
    }

    public DetailRes detail(int insectInfoIdx) throws BaseException {
        return this.searchDAO.detail(insectInfoIdx);
    }
}
