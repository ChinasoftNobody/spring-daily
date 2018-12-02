package com.lgh.spring.boot.pojo.template;

public class PropertyType<T> {
    private T value;
    private T defaultValue;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(T defaultValue) {
        this.defaultValue = defaultValue;
    }
}
