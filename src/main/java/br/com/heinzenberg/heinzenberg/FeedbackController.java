package br.com.heinzenberg.heinzenberg;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @PostMapping()
    public void requestPerson(@RequestBody Person person){
        System.out.println(person.getName());
        System.out.println(person.getLocal());
        System.out.println(person.getEmail());
        System.out.println(person.getComment());
        System.out.println(person.getQuestions());
    }
}
