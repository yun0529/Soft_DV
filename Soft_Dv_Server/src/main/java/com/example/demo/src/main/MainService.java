package com.example.demo.src.main;

import com.example.demo.config.BaseException;
import com.example.demo.src.main.model.BreedDetailRes;
import com.example.demo.src.main.model.BreedEnvRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MainService {

    private final MainDAO mainDAO;

    @Autowired
    public MainService(MainDAO mainDAO){
        this.mainDAO = mainDAO;
    }

    public ArrayList<BreedDetailRes> breedDetail() throws BaseException {
        return this.mainDAO.breedDetail();
    }

    public BreedEnvRes breedEnv() throws BaseException{
        return this.mainDAO.breedEnv();
    }
}
