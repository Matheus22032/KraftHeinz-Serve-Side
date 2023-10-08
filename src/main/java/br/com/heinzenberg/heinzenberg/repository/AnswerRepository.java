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
    private final String sqlDeleteAnswer = "DELETE FROM tb_answer WHERE person_id_fk = ?";

    public AnswerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveAnswer(Answer answer, String id){

        if (answer.getResult() == null) {
            jdbcTemplate.update(sqlAnswer, answer.getAnswerId().toString(), answer.getRanger(), answer.Id(), null, id);
            return;
        }

        jdbcTemplate.update(sqlAnswer, answer.getAnswerId().toString(),
                answer.getRanger(),
                answer.Id(),
                answer.getResult().toString(),
                id);
    }
    public PersonRequest requestAnswer(String id, PersonRequest personRequest){
        jdbcTemplate.query(sqlSelectAnswer, (rs) -> {
            do {
                Answer answer = new Answer(UUID.fromString(rs.getString("answer_id")),
                        rs.getInt("answer_range"),
                        rs.getString("answer_yes_idk") == null ? null : Answer.AnswerSet.valueOf(rs.getString("answer_yes_idk")),
                        rs.getString("tb_question_question_id"));
                personRequest.getQuestions().add(answer);
            }while (rs.next());
        }, id);
        return personRequest;
    }
    public void deleteAnswer(String id){
        jdbcTemplate.update(sqlDeleteAnswer, id);
    }
}
