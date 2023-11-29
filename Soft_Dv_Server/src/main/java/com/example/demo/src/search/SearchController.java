package com.example.demo.src.search;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src._method.InnerMethod;
import com.example.demo.src.search.object.DetailRes;
import com.example.demo.src.search.object.SearchRes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

import static com.example.demo.config.BaseResponseStatus.EMPTY_OBJECT_RETURNED;

//
@Controller
@RequestMapping("/app/search")
public class SearchController {
    private final SearchService searchService;
    private final SearchProvider searchProvider;
    private InnerMethod m = new InnerMethod();
    //Constructor
    public SearchController(SearchService searchService, SearchProvider searchProvider){
        this.searchService = searchService;
        this.searchProvider = searchProvider;
    }

    @ResponseBody
    @GetMapping("")
    public BaseResponse<ArrayList<SearchRes>> search(@RequestParam("input") String input){
        ArrayList<String> words = m._divideIntoWords(input);
        try{
            ArrayList<SearchRes> result = this.searchService.search(words);
            if(result.isEmpty()){
                throw new BaseException(EMPTY_OBJECT_RETURNED);
            }
            return new BaseResponse(result);
        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/detail")
    public BaseResponse<DetailRes> detail(@RequestParam("idx") int insectInfoIdx){
        try{
            return new BaseResponse(this.searchService.detail(insectInfoIdx));
        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }
}
