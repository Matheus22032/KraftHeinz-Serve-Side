package br.com.heinzenberg.heinzenberg.controller;

import br.com.heinzenberg.heinzenberg.entities.Person;
import br.com.heinzenberg.heinzenberg.repository.AnswerRepository;
import br.com.heinzenberg.heinzenberg.repository.PersonRepository;
import br.com.heinzenberg.heinzenberg.entities.PersonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final PersonRepository personRepository;
    private final AnswerRepository answerRepository;

    @Autowired
    public FeedbackController(PersonRepository personRepository, AnswerRepository answerRepository) {
        this.personRepository = personRepository;
        this.answerRepository = answerRepository;
    }

    @PostMapping()
    public void requestPerson(@RequestBody PersonRequest personRequest){
        Person person = new Person(personRequest);
        personRepository.save(person);
        personRequest.getQuestions().forEach((answer) -> {
            answerRepository.saveAnswer(answer, person.getPersonId().toString());
        });
    }

    @GetMapping("/person")
    public List<Person> responsePerson(){
        return personRepository.findAll();
    }

    @GetMapping("/person/{id}")
    public PersonRequest responsePerson(@PathVariable String id){
        Person person = personRepository.findById(id);
        if (person == null){
            return null;
        }
        PersonRequest personRequest = new PersonRequest(person);
        return answerRepository.requestAnswer(id, personRequest);
    }

}
