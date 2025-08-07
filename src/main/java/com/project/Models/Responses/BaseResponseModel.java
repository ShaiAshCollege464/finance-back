package com.project.Models.Responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.Objects.Entities.UserEntity;

import java.util.Map;

public class BaseResponseModel {
    private boolean error;
    private Integer code;
    @JsonIgnore
    private String sessionId;
    @JsonIgnore
    private Integer userOid;
    @JsonIgnore
    private String ip;
    @JsonIgnore
    private Map<String, String> bodyParams;
    @JsonIgnore
    private UserEntity userEntity;

    public BaseResponseModel () {
    }

    public BaseResponseModel (boolean error, Integer code) {
        this.error = error;
        this.code = code;
    }

    public BaseResponseModel (BaseResponseModel baseResponseModel) {
        this.error = baseResponseModel.isError();
        this.code = baseResponseModel.getCode();
        this.sessionId = baseResponseModel.getSessionId();
        this.userOid = baseResponseModel.getUserOid();
        this.ip = baseResponseModel.getIp();
        this.bodyParams = baseResponseModel.getBodyParams();
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getUserOid() {
        return userOid;
    }

    public void setUserOid(Integer userOid) {
        this.userOid = userOid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Map<String, String> getBodyParams() {
        return bodyParams;
    }

    public void setBodyParams(Map<String, String> bodyParams) {
        this.bodyParams = bodyParams;
    }

    public String getBodyParam(String key) {
        return bodyParams != null ? bodyParams.get(key) : null;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
