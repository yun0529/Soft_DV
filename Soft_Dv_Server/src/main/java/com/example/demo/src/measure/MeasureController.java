package com.example.demo.src.measure;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.measure.model.EnvReq;
import com.example.demo.src.measure.model.EnvRes;
import com.example.demo.src.measure.model.ManageRes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/app/measure/")
@Controller
public class MeasureController {
    private final MeasureService measureService;

    public MeasureController(MeasureService measureService){
        this.measureService = measureService;
    }

    @ResponseBody
    @PatchMapping("save")
    public BaseResponse<EnvRes> saveEnvironment(@RequestBody EnvReq envReq) {
        try{
            EnvRes result = measureService.saveEnvironment(envReq);
            return new BaseResponse<>(result);
        }catch(BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

    @ResponseBody
    @PatchMapping("set")
    public BaseResponse<EnvRes> setEnvironment(@RequestBody EnvReq envReq){
        try{
            EnvRes result = measureService.setEnvironment(envReq);
            return new BaseResponse<>(result);
        }catch(BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("get")
    public BaseResponse<EnvRes> getEnvironment(@RequestParam("mode") String mode){
        try{
            EnvRes result = measureService.getEnvironment(mode);
            return new BaseResponse<>(result);
        }catch(BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("manage")
    public BaseResponse<List<ManageRes>> manage(@RequestParam("group") int group){
        try{
            List<ManageRes> result = measureService.manage(group);
            return new BaseResponse<>(result);
        }catch(BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

}
