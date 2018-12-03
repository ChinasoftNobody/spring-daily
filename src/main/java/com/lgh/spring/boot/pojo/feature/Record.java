package com.lgh.spring.boot.pojo.feature;

import com.lgh.spring.boot.model.MRecordProperty;

import java.util.List;

public class Record{
    private List<MRecordProperty> recordProperties;
    private String createOn;
    private String updateOn;

    public String getCreateOn() {
        return createOn;
    }

    public void setCreateOn(String createOn) {
        this.createOn = createOn;
    }

    public String getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(String updateOn) {
        this.updateOn = updateOn;
    }

    public List<MRecordProperty> getRecordProperties() {
        return recordProperties;
    }

    public void setRecordProperties(List<MRecordProperty> recordProperties) {
        this.recordProperties = recordProperties;
    }
}
