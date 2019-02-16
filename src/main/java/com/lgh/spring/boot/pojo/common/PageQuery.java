package com.lgh.spring.boot.pojo.common;

import javax.validation.constraints.Min;

public class PageQuery {
    @Min(0)
    private int page;
    @Min(10)
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
