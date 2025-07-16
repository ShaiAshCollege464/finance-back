package com.project.Models.Responses;


public class StringResponseModel extends BaseResponseModel {
    private String value;

    public StringResponseModel() {
    }

    public StringResponseModel(BaseResponseModel baseResponseModel, String value) {
        super(baseResponseModel);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
