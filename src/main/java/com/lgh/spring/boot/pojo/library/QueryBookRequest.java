package com.lgh.spring.boot.pojo.library;

import com.lgh.spring.boot.pojo.common.PageQuery;

public class QueryBookRequest extends PageQuery {
    private String keyword;


    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
