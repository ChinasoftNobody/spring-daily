package com.lgh.spring.boot.mongo.model;

import java.util.UUID;

public class MBase {

    private String id;
    private long createOn;
    private long updateOn;
    private boolean del;

    public MBase() {
    }

    public MBase(boolean gen){
        this.generateBaseInfo();
    }

    public long getCreateOn() {
        return createOn;
    }

    public void setCreateOn(long createOn) {
        this.createOn = createOn;
    }

    public long getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(long updateOn) {
        this.updateOn = updateOn;
    }

    public boolean isDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void generateBaseInfo(){
        this.id = UUID.randomUUID().toString();
        this.createOn = System.currentTimeMillis();
        this.updateOn = System.currentTimeMillis();
    }
}
