package com.project.Models.Responses;


public class BooleanResponseModel extends BaseResponseModel {
    private boolean value;

    public BooleanResponseModel() {
    }

    public BooleanResponseModel(BaseResponseModel baseResponseModel, boolean value) {
        super(baseResponseModel);
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
