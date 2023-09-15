package br.com.heinzenberg.heinzenberg;

public class QuestionEnum extends Question {
    private enum ResultSet{
        SIM,
        NÃO,
        NÃO_TENHO_CERTEZA
    }
    private ResultSet result;

    public QuestionEnum(int id, ResultSet result) {
        super(id);
        this.result = result;
    }

    @Override
    public String toString() {
        return "QuestionEnum{" +
                "result=" + result +
                ", id=" + id +
                '}';
    }
}


