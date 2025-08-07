package com.project.Objects.Entities;

public class QuestionEntity {
    private int id;
    private String question;
    private int number;

    public QuestionEntity() {
    }

    public QuestionEntity(int id, String question, int number) {
        this.id = id;
        this.question = question;
        this.number = number;
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
