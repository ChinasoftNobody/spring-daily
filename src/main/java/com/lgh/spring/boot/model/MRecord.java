package com.lgh.spring.boot.model;

import java.util.List;

public class MRecord extends MBase {
    private String templateId;

    private List<MRecordProperty> properties;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public List<MRecordProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<MRecordProperty> properties) {
        this.properties = properties;
    }
}
