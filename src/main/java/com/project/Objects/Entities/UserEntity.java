package com.project.Objects.Entities;

public class UserEntity {
    private int id;
    private String phone;
    private String name;

    public UserEntity() {
    }

    public UserEntity(String phone, String name) {
        this.phone = phone;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
