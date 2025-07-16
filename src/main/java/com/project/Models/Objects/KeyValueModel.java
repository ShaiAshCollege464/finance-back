package com.project.Models.Objects;

public class KeyValueModel {
    private String key;
    private String value;

    public KeyValueModel(){
    }

    public KeyValueModel(Object key, Object value){
        this.key = String.valueOf(key);
        this.value = String.valueOf(value);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString () {
        return this.key + ":" + this.value;
    }
}
