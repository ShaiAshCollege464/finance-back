package com.project.Objects.Entities;

import java.util.Date;
import java.util.Random;

public class UserEntity extends BaseEntity{
    private String username;
    private String phone;
    private String email;
    private String password;
    private String sessionId;
    private String userKey;
    private Date activationDate;

    public UserEntity () {
    }

    public UserEntity (int oid) {
        this.setOid(oid);
    }

    public UserEntity (String username, String phone, String email, String password) {
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public void generateUserKey () {
        if (this.userKey == null || this.userKey.isEmpty()) {
            this.userKey = String.format("%s-%d", this.username.charAt(0), new Random().nextInt(1000, 9999));
        }
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }
}
