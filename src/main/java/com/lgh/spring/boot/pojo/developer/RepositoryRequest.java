package com.lgh.spring.boot.pojo.developer;

import com.lgh.spring.boot.common.PageQuery;

/**
 * Created by Administrator on 2017/7/29.
 */
public class RepositoryRequest extends PageQuery{
    private String keywords;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
