package com.lgh.spring.boot.pojo.common;

import com.lgh.spring.boot.model.MUser;

public class TokenUser extends MUser {
    private long loginTime;
    private long expireTime;

    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

}
