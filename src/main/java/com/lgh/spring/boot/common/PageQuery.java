package com.lgh.spring.boot.common;

/**
 * Created by Administrator on 2017/3/4.
 */
public class PageQuery{
    private int page;
    private int size;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
