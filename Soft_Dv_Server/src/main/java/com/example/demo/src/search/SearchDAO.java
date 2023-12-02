package com.example.demo.src.search;

import com.example.demo.src.search.object.DetailRes;
import com.example.demo.src.search.object.SearchRes;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
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

        Set<Integer> indexSet = new HashSet<>();

        for (String word : words) {
            String getIndexSql = "SELECT insectInfoIdx FROM InsectInfo WHERE " +
                    "scientificName LIKE ? " +
                    "OR kind LIKE ? " +
                    "OR sizeMax LIKE ? " +
                    "OR lifeCycle LIKE ? " +
                    "OR breedTip LIKE ? ";
            List<Integer> indexes = this.jdbcTemplate.queryForList(getIndexSql,int.class,word);

            for (int index : indexes) {
                indexSet.add(index);
            }
        }

        String getInfoSql = "SELECT kind, scientificName, image FROM InsectInfo WHERE insectInfoIdx = ?";
        for (int index : indexSet){
            result.add(
              this.jdbcTemplate.queryForObject(getInfoSql,
                      (rs,rowNum) -> new SearchRes(
                              index,
                              rs.getString("kind"),
                              rs.getString("image"),
                              rs.getString("scientificName")
                      ),index)
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
