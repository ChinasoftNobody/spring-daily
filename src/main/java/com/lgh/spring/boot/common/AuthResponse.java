package com.lgh.spring.boot.common;

/**
 *
 * @author Administrator
 * @date 2017/5/7
 */
public class AuthResponse {
    private boolean access;
    private String msg;

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
