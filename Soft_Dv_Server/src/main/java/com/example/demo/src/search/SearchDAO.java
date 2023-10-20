package com.example.demo.src.search;

import com.example.demo.src.search.object.DetailRes;
import com.example.demo.src.search.object.SearchRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

//
@Repository
public class SearchDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void SearchDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public ArrayList<SearchRes> search(ArrayList<String> words) {
        ArrayList<SearchRes> result = new ArrayList<>();
        String getIndexSql = "SELECT insectInfoIdx FROM InsectInfo WHERE scientificName = ? OR kind = ? OR sizeMax = ? OR lifeCycle = ? OR breedTip = ?";
        Set<Integer> indexSet = new HashSet<>();

        for (String word : words) {
            List<Integer> indexes = this.jdbcTemplate.query(getIndexSql,
                    (rs, rowNum)  -> new Integer(
                            rs.getInt("insectInfoIdx")
                    ), word);
            for (int i = 0; i < indexes.size(); i++) {
                indexSet.add(indexes.get(i));
            }
        }

        String getInfoSql = "SELECT kind, scientificName, image, lifeCycle FROM InsectInfo WHERE insectInfoIdx = ?";
        for (int index : indexSet){
            result.add(
              this.jdbcTemplate.query(getInfoSql,
                      (rs,rowNum) -> new SearchRes(
                              index,
                              rs.getString("kind"),
                              rs.getString("image"),
                              "종명 : "+rs.getString("kind")
                                      +", 학명 : "+rs.getString("scientificName")
                                      +", 생애주기 : "+rs.getString("lifeCycle")
                                      +", ..."
                      ),index).get(0)
            );
        }
        return result;
    }

    public DetailRes detail(int insectInfoIdx){
        String sql = "SELECT * FROM InsectInfo WHERE insectInfoIdx = "+insectInfoIdx;
        return this.jdbcTemplate.queryForObject(sql,
                (rs, rowNum) -> new DetailRes(
                        insectInfoIdx,
                        rs.getString("scientificName"),
                        rs.getString("kind"),
                        rs.getFloat("sizeMax"),
                        rs.getString("lifeCycle"),
                        rs.getString("image"),
                        rs.getString("location"),
                        rs.getString("breedTip")
                ));
    }
}
