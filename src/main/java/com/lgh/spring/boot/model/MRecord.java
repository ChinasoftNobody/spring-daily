package com.lgh.spring.boot.model;

/**
 * subject VARCHAR(255) NOT NULL COMMENT '主题',
 type VARCHAR(255) NOT NULL COMMENT '类型，收入/支出',
 amount DOUBLE COMMENT '金额',
 remarks VARCHAR(512) NULL DEFAULT NULL COMMENT '备注',
 occurrence_time DATETIME COMMENT '发生时间',
 occurrence_member INTEGER COMMENT '发生人Id',
 */
public class MRecord extends MBase {
    private String subject;
    private String type;
    private double amount;
    private String remarks;
    private String occurrenceTime;
    private MUser occurrenceMember;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(String occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public MUser getOccurrenceMember() {
        return occurrenceMember;
    }

    public void setOccurrenceMember(MUser occurrenceMember) {
        this.occurrenceMember = occurrenceMember;
    }
}
