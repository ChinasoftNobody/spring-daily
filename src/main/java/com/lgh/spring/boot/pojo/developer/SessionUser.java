package com.lgh.spring.boot.pojo.developer;

import com.lgh.spring.boot.model.MUser;

public class SessionUser extends MUser {
    private long loginTime;
    private long expireTime;
    private String sessionId;

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

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
