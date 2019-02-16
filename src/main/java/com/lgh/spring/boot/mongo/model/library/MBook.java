package com.lgh.spring.boot.mongo.model.library;

import com.lgh.spring.boot.mongo.model.MBase;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Document(collection = "t_book")
public class MBook extends MBase {
    @NotBlank
    private String name;
    private String description;
    @NotBlank
    private String imgUrl;
    @Pattern(regexp = "^word|xlsx$", message = "{validated.word-excel}")
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
