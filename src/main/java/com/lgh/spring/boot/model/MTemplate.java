package com.lgh.spring.boot.model;

import java.util.ArrayList;
import java.util.List;

public class MTemplate extends MBase {
    private int featureId;
    private String name;
    private String description;
    private List<MTemplateProperty> properties;

    public int getFeatureId() {
        return featureId;
    }

    public void setFeatureId(int featureId) {
        this.featureId = featureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MTemplateProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<MTemplateProperty> properties) {
        this.properties = properties;
    }

    public void addProperty(){
        if (properties == null){
            properties = new ArrayList<>();
        }
        properties.add(new MTemplateProperty());
    }
}
