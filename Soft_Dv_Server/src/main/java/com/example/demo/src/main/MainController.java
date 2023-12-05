package com.example.demo.src.main;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.main.model.BreedDetailRes;
import com.example.demo.src.main.model.BreedEnvRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/app/main")
public class MainController {

    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService){
        this.mainService = mainService;
    }

    @GetMapping("breedDetail")
    public BaseResponse<ArrayList<BreedDetailRes>> breedDetail(){
        try {
            ArrayList<BreedDetailRes> result = this.mainService.breedDetail();
            return new BaseResponse<>(result);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    @GetMapping("breedEnv")
    public BaseResponse<BreedEnvRes> breedEnv(){
        try{
            BreedEnvRes result = this.mainService.breedEnv();
            return new BaseResponse<>(result);
        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }
}
