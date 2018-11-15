package com.lgh.spring.boot.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/3.
 * 用户
 */
public class MUser extends MBase implements Serializable{
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
