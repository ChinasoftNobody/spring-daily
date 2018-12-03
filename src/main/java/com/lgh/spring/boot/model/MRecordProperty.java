package com.lgh.spring.boot.model;

/**
 * 记录
 */
public class MRecordProperty extends MBase {
    private int recordId;
    private String templatePropertyId;
    private String key;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getTemplatePropertyId() {
        return templatePropertyId;
    }

    public void setTemplatePropertyId(String templatePropertyId) {
        this.templatePropertyId = templatePropertyId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
