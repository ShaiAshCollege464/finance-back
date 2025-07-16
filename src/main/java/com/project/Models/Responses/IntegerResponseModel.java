package com.project.Models.Responses;

public class IntegerResponseModel extends BaseResponseModel {
    private Integer value;

    public IntegerResponseModel() {
    }

    public IntegerResponseModel(BaseResponseModel baseResponseModel, Integer value) {
        super(baseResponseModel);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
