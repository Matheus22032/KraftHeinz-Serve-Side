package br.com.heinzenberg.heinzenberg.repository;

import br.com.heinzenberg.heinzenberg.entities.Goal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class GoalRepository {

    JdbcTemplate jdbcTemplate;

    public GoalRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String sqlInsert = "INSERT INTO tb_goal (goal_id, name_goal, goal_ranger, type_esg, description) VALUES (?, ?, ?, ?, ?)";

    private final String sqlSelect = "SELECT * FROM tb_goal";

    private final String sqlSelectById = "SELECT * FROM tb_goal where goal_id = ?";

    public void saveGoal(Goal goal){
        jdbcTemplate.update(sqlInsert, goal.getId().toString(), goal.getName(), goal.getRange(), goal.getType(), goal.getDescription());
    }

    public List<Goal> findAll(){
        List<Goal> goalList = jdbcTemplate.query(sqlSelect, (rs, rowNum) -> new Goal(rs.getString("name_goal"),
                rs.getDouble("goal_ranger"),
                rs.getString("type_esg"),
                rs.getString("description"),
                rs.getString("goal_id")));
        return goalList;
    }
    public Goal findById(String id){
        Goal goal = jdbcTemplate.queryForObject(sqlSelectById, (rs, rowNum) -> new Goal(rs.getString("name_goal"),
                rs.getDouble("goal_ranger"),
                rs.getString("type_esg"),
                rs.getString("description"),
                rs.getString("goal_id")), id);
        return goal;
    }
}
