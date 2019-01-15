package com.lgh.spring.boot.model.library;

import com.lgh.spring.boot.model.MBase;

/**
 * 分类
 */
public class MClassify extends MBase {
    private int number;
    private int parentNumber;
    private String name;
    private String description;
    private String source;

    private boolean hasChildren;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getParentNumber() {
        return parentNumber;
    }

    public void setParentNumber(int parentNumber) {
        this.parentNumber = parentNumber;
    }

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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }
}
