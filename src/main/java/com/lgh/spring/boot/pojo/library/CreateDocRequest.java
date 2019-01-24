package com.lgh.spring.boot.pojo.library;

import org.springframework.web.multipart.MultipartFile;

public class CreateDocRequest {
    private String subject;
    private String type;
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
