package com.lgh.spring.boot.model;

import java.util.List;

public class MPlan extends MBase{
    private String subject;
    private List<MPlanFragment> fragments;
    private String loopType;
    private String remarks;
    private String status;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<MPlanFragment> getFragments() {
        return fragments;
    }

    public void setFragments(List<MPlanFragment> fragments) {
        this.fragments = fragments;
    }

    public String getLoopType() {
        return loopType;
    }

    public void setLoopType(String loopType) {
        this.loopType = loopType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
