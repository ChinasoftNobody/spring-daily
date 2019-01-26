package com.lgh.spring.boot.hbase.model;

/**
 * file limit 10m
 */
public class FileRow{
    private String fileId;
    private String mod;
    private byte[] content;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getMod() {
        return mod;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
