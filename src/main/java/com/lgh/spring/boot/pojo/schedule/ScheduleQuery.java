package com.lgh.spring.boot.pojo.schedule;

import com.lgh.spring.boot.common.PageQuery;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/22.
 */
public class ScheduleQuery extends PageQuery implements Serializable {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
