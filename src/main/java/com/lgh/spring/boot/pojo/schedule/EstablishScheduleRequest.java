package com.lgh.spring.boot.pojo.schedule;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/3.
 * 日程请求参数
 */
public class EstablishScheduleRequest implements Serializable{
    private String user;
    private String date;
    private String timeFrom;
    private String timeTo;
    private String goal;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}
