package br.com.heinzenberg.heinzenberg.repository;

import br.com.heinzenberg.heinzenberg.entities.Brand;
import br.com.heinzenberg.heinzenberg.entities.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BrandRepository {
    JdbcTemplate jdbcTemplate;

    private final String sqlSelect = "SELECT * FROM tb_brand";

    private final String sqlSelectById = "SELECT * FROM tb_brand WHERE brand_id = ?";

    public BrandRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Brand> findAll(){
        List<Brand> productList = new ArrayList<>();
        jdbcTemplate.query(sqlSelect, (rs, rowNum) -> productList.add(new Brand(
                        rs.getInt("brand_id"),
                        rs.getString("name_brand")
                ))
        );
        return productList;
    }

    public Brand findById(int id){
        Brand brand = jdbcTemplate.queryForObject(sqlSelectById, (rs, rowNum) -> new Brand(
                rs.getInt("brand_id"),
                rs.getString("name_brand")
        ), id);
        return brand;
    }
}
