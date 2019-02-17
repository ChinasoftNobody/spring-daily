package com.lgh.spring.boot.pojo.library;

import javax.validation.constraints.NotNull;

public class QueryLibBookRequest {
    @NotNull
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
