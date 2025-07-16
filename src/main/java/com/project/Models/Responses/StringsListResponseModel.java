package com.project.Models.Responses;

import java.util.List;

public class StringsListResponseModel extends BaseResponseModel {
    private List<String> list;

    public StringsListResponseModel() {
    }

    public StringsListResponseModel(BaseResponseModel baseResponseModel, List<String> list) {
        super(baseResponseModel);
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
