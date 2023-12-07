package com.example.demo.src.search;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.search.object.DetailRes;
import com.example.demo.src.search.object.SearchRes;
import com.example.demo.src.search.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static com.example.demo.config.BaseResponseStatus.EMPTY_OBJECT_RETURNED;

//
@Controller
@RequestMapping("/app/search")
public class SearchController {
    private final SearchService searchService;

    //Constructor
    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }

    @ResponseBody
    @GetMapping("")
    public BaseResponse<ArrayList<SearchRes>> search(@RequestParam("input") String input){

        try{
            ArrayList<SearchRes> result = this.searchService.search(input);
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

    @ResponseBody
    @PostMapping("/test")
    public BaseResponse<String> test(){
        try{
            return new BaseResponse(this.searchService.test());
        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

}
