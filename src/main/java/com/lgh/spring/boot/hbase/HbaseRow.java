package com.lgh.spring.boot.hbase;

import java.util.HashMap;

public class HbaseRow {
    private String rowKey;
    private HashMap<String,HashMap<String, byte[]>> columns;

    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    public HashMap<String, HashMap<String, byte[]>> getColumns() {
        return columns;
    }

    public void setColumns(HashMap<String, HashMap<String, byte[]>> columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "HbaseRow{" +
                "rowKey='" + rowKey + '\'' +
                ", columns=" + columns +
                '}';
    }
}
