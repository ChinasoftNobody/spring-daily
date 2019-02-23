package com.lgh.spring.boot.pojo.module;

import com.lgh.spring.boot.pojo.common.PageQuery;

public class FindModuleRequest extends PageQuery {
    private String userId;
    private String keyword;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
