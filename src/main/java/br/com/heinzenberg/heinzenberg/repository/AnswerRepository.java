package br.com.heinzenberg.heinzenberg.repository;

import br.com.heinzenberg.heinzenberg.entities.Answer;
import br.com.heinzenberg.heinzenberg.entities.PersonRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class AnswerRepository {
    private final JdbcTemplate jdbcTemplate;

    private final String sqlAnswer = "INSERT INTO tb_answer (answer_id, answer_range, tb_question_question_id, answer_yes_idk, person_id_fk) VALUES (?, ?, ?,?,?)";
    private final String sqlSelectAnswer = "SELECT * FROM tb_answer where person_id_fk = ? order by tb_question_question_id";

    public AnswerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveAnswer(Answer answer, String id){
        if (answer.getResult() == Answer.ResultSet.NÃO_TENHO_CERTEZA || answer.getResult() == null) {
            jdbcTemplate.update(sqlAnswer, answer.getAnswerId().toString(), answer.getRanger(), answer.getQuestionId(), null, id);
            return;
        }
        if (answer.getResult() == Answer.ResultSet.NÃO) {
            jdbcTemplate.update(sqlAnswer, answer.getAnswerId().toString(), answer.getRanger(), answer.getQuestionId(), false, id);
            return;
        }
        if (answer.getResult() == Answer.ResultSet.SIM) {
            jdbcTemplate.update(sqlAnswer, answer.getAnswerId().toString(), answer.getRanger(), answer.getQuestionId(), true, id);
        }
    }
    public PersonRequest requestAnswer(String id, PersonRequest personRequest){
        jdbcTemplate.query(sqlSelectAnswer, (rs) -> {
            do {
//                if (rs.getBoolean("answer_yes_idk") && (rs.getInt("tb_question_question_id") == 2|| rs.getInt("tb_question_question_id") == 3)){
//
//                }
                Answer answer = new Answer(UUID.fromString(rs.getString("answer_id")),
                        rs.getInt("answer_range"),
                        rs.getBoolean("answer_yes_idk") ? Answer.ResultSet.SIM : Answer.ResultSet.NÃO,
                        rs.getString("tb_question_question_id"));
                personRequest.getQuestions().add(answer);
            }while (rs.next());
        }, id);
        return personRequest;
    }
}
