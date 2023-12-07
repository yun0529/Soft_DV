package com.example.demo.src.measure;

import com.example.demo.config.BaseException;
import com.example.demo.src.measure.model.EnvReq;
import com.example.demo.src.measure.model.EnvRes;
import com.example.demo.src.measure.model.ManageRes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.config.BaseResponseStatus.EMPTY_OBJECT_RETURNED;

@Service
public class MeasureService {
    private final MeasureDAO measureDAO;

    public MeasureService(MeasureDAO measureDAO) {
        this.measureDAO = measureDAO;
    }

    public EnvRes saveEnvironment(EnvReq envReq) throws BaseException {
        EnvRes envRes = this.measureDAO.saveEnvironment(0,envReq);
        if(envRes == null){
            throw new BaseException(EMPTY_OBJECT_RETURNED);
        }
        return envRes;
    }

    public EnvRes setEnvironment(EnvReq envReq) throws BaseException {
        EnvRes envRes = this.measureDAO.saveEnvironment(1,envReq);
        if(envRes == null){
            throw new BaseException(EMPTY_OBJECT_RETURNED);
        }
        return envRes;
    }

    public EnvRes getEnvironment(String mode) throws BaseException {
        EnvRes envRes = this.measureDAO.getEnvironment(mode);
        if(envRes == null){
            throw new BaseException(EMPTY_OBJECT_RETURNED);
        }
        return envRes;
    }

    public List<ManageRes> manage(int group) throws BaseException {
        List<ManageRes> result = this.measureDAO.manage(group);

        return result;
    }
}
