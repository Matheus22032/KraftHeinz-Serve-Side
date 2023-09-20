package br.com.heinzenberg.heinzenberg.repository;


import br.com.heinzenberg.heinzenberg.entities.Person;
import br.com.heinzenberg.heinzenberg.request.PersonRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class PersonRepository {
    private final JdbcTemplate jdbcTemplate;

    private final String sqlPerson = "INSERT INTO tb_person (person_id, name_person, local_person, email, tb_questionary_questionary_id) VALUES (?, ?, ?, ?, ?)";
    private final String sqlComment = "INSERT INTO tb_comment (comment_id, comment_text, tb_person_person_id) VALUES (?, ?, ?)";

    public PersonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Person person) {
        jdbcTemplate.update(sqlPerson, person.getPersonId().toString(), person.getName(), person.getLocal(), person.getEmail(), 1);
        if (person.getComment() != null) {
            jdbcTemplate.update(sqlComment, UUID.randomUUID().toString(), person.getComment(), person.getPersonId().toString());
        }

    }
}
