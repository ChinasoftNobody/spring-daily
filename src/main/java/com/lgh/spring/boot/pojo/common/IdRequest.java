package com.lgh.spring.boot.pojo.common;

import javax.validation.constraints.NotEmpty;

public class IdRequest {
    @NotEmpty
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
