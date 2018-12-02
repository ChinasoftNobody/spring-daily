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

    String RECORD_TYPE_NAME_SIMPLE="普通";
    String RECORD_TYPE_NAME_OTHER="其他";
    int RECORD_TYPE_ID_SIMPLE=0;
    int RECORD_TYPE_ID_OTHER=1;

    int TEMPLATE_TYPE_STRING = 0;
    int TEMPLATE_TYPE_INTERGER = 1;
}
