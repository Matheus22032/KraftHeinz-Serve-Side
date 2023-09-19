package br.com.heinzenberg.heinzenberg.controller;

import br.com.heinzenberg.heinzenberg.repository.PersonRepository;
import br.com.heinzenberg.heinzenberg.request.PersonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final PersonRepository personRepository;

    @Autowired
    public FeedbackController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping()
    public void requestPerson(@RequestBody PersonRequest personRequest){
        personRepository.save(personRequest);
    }

}
