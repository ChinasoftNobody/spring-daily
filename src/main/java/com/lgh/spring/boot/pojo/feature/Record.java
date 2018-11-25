package com.lgh.spring.boot.pojo.feature;

import com.lgh.spring.boot.model.MRecord;

public class Record extends MRecord{
    private String ownerName;
    private String typeName;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
