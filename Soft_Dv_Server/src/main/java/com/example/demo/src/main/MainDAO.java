package com.example.demo.src.main;

import com.example.demo.src.main.model.BreedDetailRes;
import com.example.demo.src.main.model.BreedEnvRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;

@Repository
public class MainDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MainDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public ArrayList<BreedDetailRes> breedDetail(){
        String sql = "SELECT scientificName, image FROM InsectInfo LIMIT 7";
        return new ArrayList<>(this.jdbcTemplate.queryForList(sql, BreedDetailRes.class));
    }

    public BreedEnvRes breedEnv(){
        String sql = "SELECT setTemperature,curTemperature,setMoisture,curMoisture FROM Machine WHERE machineIdx = 1";
        return this.jdbcTemplate.queryForObject(sql,(rs,rowNum)->new BreedEnvRes(

        ));
    }
}
