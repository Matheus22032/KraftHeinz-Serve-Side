package br.com.heinzenberg.heinzenberg.repository;

import br.com.heinzenberg.heinzenberg.entities.Answer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AnswerRepository {
    private final JdbcTemplate jdbcTemplate;

    private final String sqlAnswer = "INSERT INTO tb_answer (answer_id, answer_range, tb_question_question_id, answer_yes_idk) VALUES (?, ?, ?,?)";

    public AnswerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveAnswer(Answer answer){
        if (answer.getResult() == Answer.ResultSet.NÃO_TENHO_CERTEZA || answer.getResult() == null) {
            jdbcTemplate.update(sqlAnswer, answer.getAnswerId().toString(), answer.getRanger(), answer.getId(), null);
            return;
        }
        if (answer.getResult() == Answer.ResultSet.NÃO) {
            jdbcTemplate.update(sqlAnswer, answer.getAnswerId().toString(), answer.getRanger(), answer.getId(), false);
            return;
        }
        if (answer.getResult() == Answer.ResultSet.SIM) {
            jdbcTemplate.update(sqlAnswer, answer.getAnswerId().toString(), answer.getRanger(), answer.getId(), true);
        }
    }
}
