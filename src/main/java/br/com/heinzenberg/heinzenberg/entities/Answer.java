package br.com.heinzenberg.heinzenberg.entities;

import java.util.UUID;

public  class Answer {
    public enum ResultSet{
        SIM, NÃO, NÃO_TENHO_CERTEZA
    }
    private UUID answerId;
    private int id;
    private int ranger;
    private ResultSet result;

    public Answer(int id, int ranger, ResultSet result) {
        this.id = id;
        this.ranger = ranger;
        this.result = result;
        this.answerId = UUID.randomUUID();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRanger(int ranger) {
        this.ranger = ranger;
    }

    public void setResult(ResultSet result) {
        this.result = result;
    }

    public UUID getAnswerId() {
        return answerId;
    }

    public int getId() {
        return id;
    }

    public int getRanger() {
        return ranger;
    }

    public ResultSet getResult() {
        return result;
    }
}
