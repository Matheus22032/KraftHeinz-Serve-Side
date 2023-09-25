package br.com.heinzenberg.heinzenberg.repository;


import br.com.heinzenberg.heinzenberg.entities.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    JdbcTemplate jdbcTemplate;

    private final String sqlSelect = "SELECT * FROM tb_product";

    private final String sqlSelectById = "SELECT * FROM tb_product WHERE sku = ?";

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> findAll(){
        List<Product> productList = new ArrayList<>();
        jdbcTemplate.query(sqlSelect, (rs, rowNum) -> productList.add(new Product(
                    rs.getInt("sku"),
                    rs.getString("name_product"),
                    rs.getInt("tb_brand_brand_id")
            ))
         );
        return productList;
    }

    public Product findById(int id){
        Product product = jdbcTemplate.queryForObject(sqlSelectById, (rs, rowNum) -> new Product(
                rs.getInt("sku"),
                rs.getString("name_product"),
                rs.getInt("tb_brand_brand_id")
        ), id);
        return product;
    }
}
