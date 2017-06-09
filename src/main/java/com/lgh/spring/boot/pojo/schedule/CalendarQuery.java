package com.lgh.spring.boot.pojo.schedule;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/29.
 */
public class CalendarQuery implements Serializable{
    private String month;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
