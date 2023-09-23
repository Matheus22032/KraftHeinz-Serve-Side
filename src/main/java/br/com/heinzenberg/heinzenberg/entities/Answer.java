package br.com.heinzenberg.heinzenberg.entities;

import java.util.UUID;

public  class Answer {
    public enum ResultSet{
        SIM, NÃO, NÃO_TENHO_CERTEZA
    }
    private UUID answerId;
    private int ranger;
    private ResultSet result;

    private String questionId;

    public Answer( int ranger, ResultSet result, String questionId) {
        this.answerId = UUID.randomUUID();
        this.ranger = ranger;
        this.result = result;
        this.questionId = questionId;
    }

    public Answer(UUID answerId, int ranger, ResultSet result, String questionId) {
        this.answerId = answerId;
        this.ranger = ranger;
        this.result = result;
        this.questionId = questionId;
    }


    public void setRanger(int ranger) {
        this.ranger = ranger;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setResult(ResultSet result) {
        this.result = result;
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
}
