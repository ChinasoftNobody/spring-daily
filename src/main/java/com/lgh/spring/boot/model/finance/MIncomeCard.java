package com.lgh.spring.boot.model.finance;

import com.lgh.spring.boot.model.MBase;

public class MIncomeCard extends MBase {

    private String subject;

    private double amount;

    private MIncomeCardFrequency frequency;

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

    public MIncomeCardFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(MIncomeCardFrequency frequency) {
        this.frequency = frequency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
