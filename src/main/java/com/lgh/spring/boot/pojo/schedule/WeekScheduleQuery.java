package com.lgh.spring.boot.pojo.schedule;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/29.
 */
public class WeekScheduleQuery implements Serializable{
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
