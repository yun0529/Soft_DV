package com.example.demo.src.measure;

import com.example.demo.src.measure.model.EnvReq;
import com.example.demo.src.measure.model.EnvRes;
import com.example.demo.src.measure.model.ManageRes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

    public ManageRes manage(int group){
        String sql = "SELECT insectIdx, groupIdx,sex, family, weight, size," +
                " adult, recommandTemperature, recommandMoisture," +
                " kind, image " +
                " FROM Insect" +
                " right join InsectInfo on Insect.insectInfoIdx = InsectInfo.insectInfoIdx" +
                " WHERE Insect.groupIdx = "+group;
        ManageRes result = this.jdbcTemplate.queryForObject(sql,(rs,rowNum)->new ManageRes(
                rs.getInt("insectIndex"),
                group,
                rs.getInt("insectInfoIdx"),
                rs.getInt("family"),
                rs.getString("sex"),
                rs.getDouble("weight"),
                rs.getDouble("size"),
                rs.getDouble("recommendTemperature"),
                rs.getDouble("recommendMoisture"),
                rs.getBoolean("adult"),
                rs.getString("image")
        ));
        return result;
    }
}
