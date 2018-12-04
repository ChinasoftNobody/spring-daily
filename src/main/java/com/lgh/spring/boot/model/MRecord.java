package com.lgh.spring.boot.model;

import java.util.List;

public class MRecord extends MBase {
    private int templateId;

    private List<MRecordProperty> properties;

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public List<MRecordProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<MRecordProperty> properties) {
        this.properties = properties;
    }
}
