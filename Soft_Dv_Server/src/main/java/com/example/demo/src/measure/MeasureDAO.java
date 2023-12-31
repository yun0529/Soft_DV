package com.example.demo.src.measure;

import com.example.demo.src.measure.model.EnvReq;
import com.example.demo.src.measure.model.EnvRes;
import com.example.demo.src.measure.model.ManageRes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MeasureDAO {

    private final JdbcTemplate jdbcTemplate;

    public MeasureDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public EnvRes saveEnvironment(int mode, EnvReq envReq){
        String sql = "";
        if(mode == 0) { // save
            sql = "UPDATE Machine SET curTemperature = ?, curMoisture = ? WHERE machineIdx = ? ";
        }
        else if (mode == 1) { // set
            sql = "UPDATE Machine SET setTemperature = ?, setMoisture = ? WHERE machineIdx = ? ";
        }
        Object[] param = {envReq.getTemperature(), envReq.getHumidity(), envReq.getMachineIdx()};
        int sqlResult = this.jdbcTemplate.update(sql, param);

        if(sqlResult == 0) // fail
        {
            return null;
        }
        else
        {
            return new EnvRes(envReq.getTemperature(), envReq.getHumidity());
        }
    }

    public EnvRes getEnvironment(String mode){
        String sql = "";
        String word = "";
        if(mode.toLowerCase().equals("cur")) { // current
            sql = "SELECT curTemperature, curMoisture FROM Machine WHERE machineIdx = ? ";
            return this.jdbcTemplate.query(sql,(rs,rowNum)-> new EnvRes(
                    rs.getDouble("curTemperature"),
                    rs.getDouble("curMoisture")
            ),1).get(0);
        }
        else if (mode.toLowerCase().equals("set")) { // set
            sql = "SELECT setTemperature, setMoisture FROM Machine WHERE machineIdx = ? ";
            return this.jdbcTemplate.query(sql,(rs,rowNum)-> new EnvRes(
                    rs.getDouble("setTemperature"),
                    rs.getDouble("setMoisture")
            ),1).get(0);
        }
    return null;
    }

    public List<ManageRes> manage(int group){
        List<ManageRes> result = new ArrayList<>();
        String sql = "SELECT insectIdx, groupIdx,Insect.insectInfoIdx,sex, family, weight, size," +
                " adult, recommendTemperature, recommendMoisture, InsectInfo.kind," +
                " image " +
                " FROM Insect" +
                " right join InsectInfo on Insect.insectInfoIdx = InsectInfo.insectInfoIdx" +
                " WHERE Insect.groupIdx = "+group;
        List<Map<String,Object>> sqlResult = this.jdbcTemplate.queryForList(sql);
        for(Map<String,Object> m : sqlResult){
            result.add(new ManageRes(
                    (int)m.get("insectIdx"),
                    group,
                    (int)m.get("insectInfoIdx"),
                    (int)m.get("family"),
                    (String)m.get("sex"),
                    (double)m.get("weight"),
                    (double)m.get("size"),
                    (double)m.get("recommendTemperature"),
                    (double)m.get("recommendMoisture"),
                    (String)m.get("kind"),
                    (int)m.get("adult"),
                    (String)m.get("image")
            ));
        }
        return result;
    }
}