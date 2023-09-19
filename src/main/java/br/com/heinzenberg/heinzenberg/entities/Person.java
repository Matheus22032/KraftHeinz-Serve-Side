package br.com.heinzenberg.heinzenberg.entities;

import br.com.heinzenberg.heinzenberg.request.PersonRequest;

import java.util.UUID;

public class Person {
    private UUID personId;
    private String name;
    private String local;
    private String email;
    private String comment;

    public Person (PersonRequest personRequest){
        this.name = personRequest.getName();
        this.local = personRequest.getLocal();
        this.email = personRequest.getEmail();
        this.comment = personRequest.getComment();
        this.personId = UUID.randomUUID();
    }

    public UUID getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public String getLocal() {
        return local;
    }

    public String getEmail() {
        return email;
    }

    public String getComment() {
        return comment;
    }
}
