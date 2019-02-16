package com.lgh.spring.boot.pojo.library;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CreateDocRequest {
    @NotBlank
    private String subject;
    @NotBlank
    @Pattern(regexp = "^docx|xlsx$", message = "Type error")
    private String type;
    @NotNull
    private MultipartFile file;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
