package com.lgh.spring.boot.mongo.model.mylib;

import com.lgh.spring.boot.mongo.model.MBase;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "t_book")
public class MDoc extends MBase {
    private String subject;
    private String type;
    private List<String> files;

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

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }
}
