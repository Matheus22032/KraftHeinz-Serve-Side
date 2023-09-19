package br.com.heinzenberg.heinzenberg.entities;

public class QuestionInt extends Question{
    private int ranger;
    public QuestionInt(int id, int ranger) {
        super(id);
        this.ranger = ranger;
    }

    @Override
    public String toString() {
        return "QuestionInt{" +
                "ranger=" + ranger +
                ", id=" + id +
                '}';
    }
}
