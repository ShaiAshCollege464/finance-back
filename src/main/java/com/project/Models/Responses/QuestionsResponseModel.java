package com.project.Models.Responses;

import com.project.Models.Objects.QuestionModel;
import com.project.Objects.Entities.QuestionEntity;

import java.util.List;

public class QuestionsResponseModel extends BaseResponseModel{
    private List<QuestionModel> questions;

    public QuestionsResponseModel() {
    }

    public QuestionsResponseModel(BaseResponseModel baseResponseModel, List<QuestionEntity> questions) {
        super(baseResponseModel);
        this.questions = questions.stream().map(QuestionModel::new).toList();
    }

    public List<QuestionModel> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionModel> questions) {
        this.questions = questions;
    }
}
