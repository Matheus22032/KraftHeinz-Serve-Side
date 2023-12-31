package br.com.heinzenberg.heinzenberg.repository;

import br.com.heinzenberg.heinzenberg.entities.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class PersonRepository {
    private final JdbcTemplate jdbcTemplate;

    private final String sqlPerson = "INSERT INTO tb_person (person_id, name_person, local_person, email, comment_person) VALUES (?, ?, ?, ?,?)";
    private final String sqlSelectPerson = "SELECT * FROM tb_person where comment_person is not null";
    private final String sqlSelectPersonById = "SELECT * FROM tb_person where person_id = ?";
    private final String sqlUpdateFeedback = "UPDATE tb_person SET boolean_feedback = ? WHERE person_id = ?";
    private final String sqlUpdateAnswered = "UPDATE tb_person SET answered = 1 WHERE person_id = ?";
    private final String sqlUpdateTypeEsg = "UPDATE tb_person SET type_esg = ? WHERE person_id = ?";
    private final String sqlDeletePerson = "DELETE FROM tb_person WHERE person_id = ?";
    private final AnswerRepository answerRepository;

    public PersonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        answerRepository = new AnswerRepository(jdbcTemplate);
    }

    public void save(Person person) {
        jdbcTemplate.update(sqlPerson, person.getPersonId().toString(), person.getName(), person.getLocal(), person.getEmail(), person.getComment());
    }

    public List<Person> findAll() {
        List<Person> personList = jdbcTemplate.query(sqlSelectPerson, (rs, rowNum) -> new Person(rs.getString("name_person"),
                rs.getString("local_person"),
                rs.getString("email"),
                rs.getString("comment_person"),
                UUID.fromString(rs.getString("person_id")),
                rs.getBoolean("boolean_feedback"),
                rs.getString("type_esg"),
                rs.getBoolean("answered")));
        return personList;
    }

    public Person findById(String id) {
        AtomicReference<Person> person = new AtomicReference<>(new Person());
        jdbcTemplate.query(sqlSelectPersonById, (rs) -> {
            person.set(new Person(rs.getString("name_person"),
                    rs.getString("local_person"),
                    rs.getString("email"),
                    rs.getString("comment_person"),
                    UUID.fromString(rs.getString("person_id")),
                    rs.getBoolean("boolean_feedback"),
                    rs.getString("type_esg"),
                    rs.getBoolean("answered")));
        }, id);

        return person.get();
    }
    public void updateFeedback(String id, boolean feedback){
        jdbcTemplate.update(sqlUpdateFeedback,  feedback,id);
    }

    public void updateAnswered(String id){
        jdbcTemplate.update(sqlUpdateAnswered, id);
    }
    public void updateTypeEsg(String id, String typeEsg){
        jdbcTemplate.update(sqlUpdateTypeEsg, typeEsg, id);
    }
    public void deletePerson(String id){
       answerRepository.deleteAnswer(id);
        jdbcTemplate.update(sqlDeletePerson, id);
    }
}
