package br.com.heinzenberg.heinzenberg;

import java.util.List;


public class Person {
    private String name;
    private String local;

    private String email;
    private List<Question> questions;
    private String comment;

    public Person(String name, String local, String email, List<Question> questions, String comment) {
        this.name = name;
        this.local = local;
        this.email = email;
        this.questions = questions;
        this.comment = comment;
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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
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
