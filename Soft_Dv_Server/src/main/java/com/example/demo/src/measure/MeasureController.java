package com.example.demo.src.measure;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.measure.model.EnvReq;
import com.example.demo.src.measure.model.EnvRes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/app/measure/")
@Controller
public class MeasureController {
    private final MeasureService measureService;

    public MeasureController(MeasureService measureService){
        this.measureService = measureService;
    }

    @ResponseBody
    @PostMapping("save")
    public BaseResponse<EnvRes> saveEnvironment(@RequestBody EnvReq envReq) {
        try{
            EnvRes result = measureService.saveEnvironment(envReq);
            return new BaseResponse<>(result);
        }catch(BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

    @ResponseBody
    @PostMapping("set")
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
    public BaseResponse<EnvRes> getEnvironment(@RequestParam String mode){
        try{
            EnvRes result = measureService.getEnvironment(mode);
            return new BaseResponse<>(result);
        }catch(BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

}
