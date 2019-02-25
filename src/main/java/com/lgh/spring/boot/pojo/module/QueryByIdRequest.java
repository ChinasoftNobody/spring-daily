package com.lgh.spring.boot.pojo.module;

import javax.validation.constraints.NotEmpty;

public class QueryByIdRequest {
    @NotEmpty
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
