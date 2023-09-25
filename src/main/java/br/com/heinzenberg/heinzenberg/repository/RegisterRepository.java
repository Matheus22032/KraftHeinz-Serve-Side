package br.com.heinzenberg.heinzenberg.repository;

import br.com.heinzenberg.heinzenberg.entities.Register;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterRepository {
    private final JdbcTemplate jdbcTemplate;

    private final String sqlInsertData = "INSERT INTO tb_data (data_id, country, qtd_comment, date_, tb_brand_brand_ID, tb_product_sku, feedback_data) VALUES (?, ?, ?, ?,?,?,?)";

    private final String sqlInsertDataGoal = "INSERT INTO tb_data_goal (tb_data_data_id, tb_goal_goal_id) VALUES (?, ?)";

    public RegisterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Register register) {
        jdbcTemplate.update(sqlInsertData, register.getId().toString(),
                register.getLocal(), register.getQtd_comment(),
                register.getDate(), register.getBrandId(), register.getProductSku(),register.getFeedback());

        register.getGoals().forEach(goal -> jdbcTemplate.update(sqlInsertDataGoal, register.getId().toString(), goal));
    }


}

