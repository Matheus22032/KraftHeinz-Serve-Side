package br.com.heinzenberg.heinzenberg;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(QuestionInt.class), @JsonSubTypes.Type(QuestionEnum.class)})
public abstract class Question {
    int id;

    public Question(int id) {
        this.id = id;
    }

}
