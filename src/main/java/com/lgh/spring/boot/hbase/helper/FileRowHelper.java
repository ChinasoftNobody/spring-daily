package com.lgh.spring.boot.hbase.helper;

import com.lgh.spring.boot.hbase.model.FileRow;


public interface FileRowHelper {
    boolean insert(FileRow fileRow);
}
