package com.project.Objects.Entities;

public class AnswerEntity {
    private int id;
    private int userId;
    private int questionId;
    private String answer;

    public AnswerEntity(int userId, int questionId, String answer) {
        this.userId = userId;
        this.questionId = questionId;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
