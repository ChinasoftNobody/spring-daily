package com.lgh.spring.boot.mongo.model.mylib;

import com.lgh.spring.boot.mongo.model.MBase;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "t_book")
public class MDoc extends MBase {
    private String subject;
    private String type;
    private String fileName;
    private String fileId;

    public MDoc() {
    }

    public MDoc(boolean gen) {
        super(gen);
    }

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}
