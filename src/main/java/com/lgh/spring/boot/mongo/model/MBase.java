package com.lgh.spring.boot.mongo.model;

public class MBase {

    private int id;
    private String createOn;
    private String updateOn;
    private boolean del;

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


    public boolean isDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}