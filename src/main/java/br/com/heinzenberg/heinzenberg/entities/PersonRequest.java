package br.com.heinzenberg.heinzenberg.entities;


import java.util.ArrayList;
import java.util.List;


public class PersonRequest {
    private String name;
    private String local;

    private String email;

    private List<Answer> questions;
    private String comment;

    public PersonRequest(String name, String local, String email, List<Answer> questions, String comment) {
        this.name = name;
        this.local = local;
        this.email = email;
        this.questions = questions;
        this.comment = comment;
    }
    public PersonRequest(){
        this.questions = new ArrayList<>();
    }

    public PersonRequest(Person person){
        this.name = person.getName();
        this.local = person.getLocal();
        this.email = person.getEmail();
        this.comment = person.getComment();
        this.questions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Answer> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Answer> questions) {
        this.questions = questions;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", local='" + local + '\'' +
                ", email='" + email + '\'' +
                ", questions=" + questions +
                ", comment='" + comment + '\'' +
                '}';
    }
}
