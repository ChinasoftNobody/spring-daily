package com.lgh.spring.boot.mongo.model.library;

import com.lgh.spring.boot.mongo.model.MBase;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "t_book")
public class MBook extends MBase {
    @NotBlank
    private String name;
    private String description;
    private String imgUrl;
    private String type;
    private String author;
    private String link;
    private String age;
    private String publishFrom;
    private String callNumber;
    private String detailUrl;

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

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setPublishFrom(String publishFrom) {
        this.publishFrom = publishFrom;
    }

    public String getPublishFrom() {
        return publishFrom;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getDetailUrl() {
        return detailUrl;
    }
}
