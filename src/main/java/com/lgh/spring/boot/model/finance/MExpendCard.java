package com.lgh.spring.boot.model.finance;

import com.lgh.spring.boot.model.MBase;

public class MExpendCard extends MBase {

    private String subject;

    private double amount;

    private MExpendCardFrequency frequency;

    private String description;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public MExpendCardFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(MExpendCardFrequency frequency) {
        this.frequency = frequency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
