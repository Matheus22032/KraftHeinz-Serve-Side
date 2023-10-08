package br.com.heinzenberg.heinzenberg.entities;

import java.util.UUID;

public class Person {
    private UUID personId;
    private String name;
    private String local;
    private String email;
    private String comment;
    private boolean feedback;
    private String typeEsg;
    private boolean Answered;


    public Person (PersonRequest personRequest){
        this.name = personRequest.getName();
        this.local = personRequest.getLocal();
        this.email = personRequest.getEmail();
        this.comment = personRequest.getComment();
        this.personId = UUID.randomUUID();
    }

    public Person(){

    }

    public Person(String name, String local, String email,String comment, UUID personId, boolean feedback, String typeEsg, boolean answered) {
        this.name = name;
        this.local = local;
        this.email = email;
        this.personId = personId;
        this.comment = comment;
        this.Answered = answered;
        this.feedback = feedback;
        this.typeEsg = typeEsg;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public boolean isFeedback() {
        return feedback;
    }

    public String getTypeEsg() {
        return typeEsg;
    }

    public boolean isAnswered() {
        return Answered;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", local='" + local + '\'' +
                ", email='" + email + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
