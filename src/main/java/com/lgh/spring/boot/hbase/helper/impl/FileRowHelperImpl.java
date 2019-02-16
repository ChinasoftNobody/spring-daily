package com.lgh.spring.boot.hbase.helper.impl;

import com.lgh.spring.boot.hbase.HbaseHandler;
import com.lgh.spring.boot.hbase.HbaseRow;
import com.lgh.spring.boot.hbase.helper.FileRowHelper;
import com.lgh.spring.boot.hbase.model.FileRow;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//@Service
public class FileRowHelperImpl implements FileRowHelper {

    private static final String TABLE_NAME = "t_file";
    @Resource
    private HbaseHandler hbaseHandler;

    @Override
    public boolean insert(FileRow fileRow) {
        List<String> columns = new ArrayList<>(2);
        columns.add("basic");
        columns.add("content");

        hbaseHandler.createTable(TABLE_NAME, columns);
        HbaseRow hbaseRow = new HbaseRow();
        hbaseRow.setRowKey(fileRow.getFileId());
        HashMap<String, HashMap<String, byte[]>> columnMap = new HashMap<>();
        HashMap<String, byte[]> basicColumns = new HashMap<>();
        basicColumns.put("mod", fileRow.getMod().getBytes());
        columnMap.put("basic", basicColumns);
        HashMap<String, byte[]> contentColumns = new HashMap<>();
        contentColumns.put("content", fileRow.getContent());
        columnMap.put("content", contentColumns);
        hbaseRow.setColumns(columnMap);
        return hbaseHandler.put(TABLE_NAME, hbaseRow);
    }
}
