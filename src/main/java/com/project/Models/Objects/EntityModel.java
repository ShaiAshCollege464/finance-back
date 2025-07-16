package com.project.Models.Objects;

public class EntityModel {
    private int oid;

    public EntityModel () {
    }

    public EntityModel (int oid) {
        this.oid = oid;
    }


    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }
}
