package com.lgh.spring.boot.common;

/**
 *
 * @author Administrator
 * @date 2017/5/12
 *
 */
public interface Const {
    enum EventType{
        LEARN,FAMLIY,JOB,REST,THINKING,FUNNING
    }

    String SESSION_USER_KEY = "user";
}
