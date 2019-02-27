package com.lgh.spring.boot.pojo.plugin;

import com.lgh.spring.boot.pojo.common.PageQuery;

public class FindAllRequest extends PageQuery {
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
