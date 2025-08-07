package com.project.Models.Objects;

import com.project.Objects.Entities.QuestionEntity;

public class QuestionModel {
    private int id;
    private String question;
    private int number;

    public QuestionModel() {
    }


    public QuestionModel(QuestionEntity questionEntity) {
        this.id = questionEntity.getId();
        this.question = questionEntity.getQuestion();
        this.number = questionEntity.getNumber();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
