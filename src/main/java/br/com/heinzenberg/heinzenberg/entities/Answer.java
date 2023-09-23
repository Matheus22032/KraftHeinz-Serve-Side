package br.com.heinzenberg.heinzenberg.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public  class Answer {
    public enum ResultSet{
        SIM, NÃO, NÃO_TENHO_CERTEZA
    }
    private UUID answerId;
    private int ranger;
    private ResultSet result;

    private String Id;

    public Answer( int ranger, ResultSet result, String questionId) {
        this.answerId = UUID.randomUUID();
        this.ranger = ranger;
        this.result = result;
        this.Id = questionId;
    }

    public Answer(UUID answerId, int ranger, ResultSet result, String Id) {
        this.answerId = answerId;
        this.ranger = ranger;
        this.result = result;
        this.Id = Id;
    }

    @JsonCreator
    public Answer(@JsonProperty("id") String Id, @JsonProperty("result") ResultSet result) {
        this.answerId = UUID.randomUUID();
        this.result = result;
        this.Id = Id;
    }

    public void setRanger(int ranger) {
        this.ranger = ranger;
    }

    public String Id() {
        return Id;
    }

    public void setResult(ResultSet result) {
        this.result = result;
    }

    public void setQuestionId(String questionId) {
        this.Id = questionId;
    }

    public UUID getAnswerId() {
        return answerId;
    }

    public int getRanger() {
        return ranger;
    }

    public ResultSet getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", ranger=" + ranger +
                ", result=" + result +
                ", questionId='" + Id + '\'' +
                '}';
    }
}
