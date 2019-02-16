package com.lgh.spring.boot.hbase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

//@Component
public class HbaseHandler {

    private static final Log LOG = LogFactory.getLog(HbaseHandler.class);

    private static Connection connection;

    static {
        try {
            Configuration conf = HBaseConfiguration.create();
            LOG.info("hbase.zookeeper.quorum:" + conf.get("hbase.zookeeper.quorum"));
            connection = ConnectionFactory.createConnection(conf);
            LOG.info("hbase connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public synchronized boolean createTable(String tableName, List<String> columnFamilies) {
        try {
            if (StringUtils.isEmpty(tableName) || columnFamilies == null || columnFamilies.isEmpty()) {
                LOG.error("table name and columnFamilies can not be empty");
                return false;
            }
            Admin admin = connection.getAdmin();
            TableName table = TableName.valueOf(tableName);
            if (admin.tableExists(table)) {
                LOG.info("table exists");
                return true;
            }
            List<ColumnFamilyDescriptor> familyDescriptors = new ArrayList<>(columnFamilies.size());
            columnFamilies.forEach(familyName -> familyDescriptors.add(ColumnFamilyDescriptorBuilder.newBuilder(familyName.getBytes()).build()));
            TableDescriptor descriptor = TableDescriptorBuilder.newBuilder(table).setColumnFamilies(familyDescriptors).build();
            admin.createTable(descriptor);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private TableDescriptor getDesc(String tableName) {
        try {
            Admin admin = connection.getAdmin();
            TableName name = TableName.valueOf(tableName);
            if (!admin.tableExists(name)) {
                return null;
            }
            return admin.getDescriptor(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public HbaseRow getByKey(String tableName, String rowKey) {
        try {
            if (StringUtils.isEmpty(rowKey) || StringUtils.isEmpty(tableName)){
                LOG.error("table name or keys can not be empty");
                return null;
            }
            TableDescriptor tableDescriptor = getDesc(tableName);
            if (tableDescriptor == null) {
                LOG.error("can not get table desc:" + tableName);
                return null;
            }
            Table table = connection.getTable(TableName.valueOf(tableName.getBytes()));
            Get get = new Get(rowKey.getBytes());
            Result result = table.get(get);
            return packRow(result, tableDescriptor);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HbaseRow> getByKeys(String tableName, List<String> rowKeys) {
        try {
            if (rowKeys == null || rowKeys.isEmpty() || StringUtils.isEmpty(tableName)){
                LOG.error("table name or keys can not be empty");
                return null;
            }
            TableDescriptor desc = getDesc(tableName);
            if (desc == null) {
                LOG.error("can not get table desc:" + tableName);
                return null;
            }
            Table table = connection.getTable(TableName.valueOf(tableName));
            List<Get> gets = new ArrayList<>(rowKeys.size());
            for (String key: rowKeys){
                gets.add(new Get(key.getBytes()));
            }
            Result[] results = table.get(gets);
            return packRows(results, desc);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<HbaseRow> packRows(Result[] results, TableDescriptor desc) {
        List<HbaseRow> hbaseRows = new ArrayList<>(results.length);
        for (Result result: results){
            hbaseRows.add(packRow(result, desc));
        }
        return hbaseRows;
    }

    private HbaseRow packRow(Result result, TableDescriptor tableDescriptor) {
        HbaseRow hbaseRow = new HbaseRow();
        hbaseRow.setRowKey(new String(result.getRow()));
        ColumnFamilyDescriptor[] columnFamilies = tableDescriptor.getColumnFamilies();
        HashMap<String, HashMap<String, byte[]>> hashMap = new HashMap<>(1);
        for (ColumnFamilyDescriptor descriptor : columnFamilies) {
            byte[] family = descriptor.getName();
            NavigableMap<byte[], byte[]> familyMap = result.getFamilyMap(family);
            HashMap<String, byte[]> subMap = new HashMap<>();
            Iterator<Map.Entry<byte[], byte[]>> iterator = familyMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<byte[], byte[]> next = iterator.next();
                subMap.put(new String(next.getKey()), next.getValue());
            }
            hashMap.put(descriptor.getNameAsString(), subMap);
        }
        hbaseRow.setColumns(hashMap);
        return hbaseRow;
    }

    public boolean put(String tableName, List<HbaseRow> rows) {
        try {
            if (StringUtils.isEmpty(tableName) || rows == null || rows.isEmpty()) {
                LOG.error("table name or rows can not be empty");
                return false;
            }
            Table table = connection.getTable(TableName.valueOf(tableName));
            List<Put> puts = new ArrayList<>(rows.size());
            rows.forEach(hbaseRow -> {
                Put put = new Put(hbaseRow.getRowKey().getBytes());
                Iterator<Map.Entry<String, HashMap<String, byte[]>>> iterator = hbaseRow.getColumns().entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, HashMap<String, byte[]>> familyColumns = iterator.next();
                    Iterator<Map.Entry<String, byte[]>> entryIterator = familyColumns.getValue().entrySet().iterator();
                    while (entryIterator.hasNext()) {
                        Map.Entry<String, byte[]> columnEntry = entryIterator.next();
                        put.addColumn(familyColumns.getKey().getBytes(), columnEntry.getKey().getBytes(), columnEntry.getValue());
                    }
                }
                puts.add(put);
            });
            table.put(puts);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean put(String tableName, HbaseRow row) {
        if (StringUtils.isEmpty(tableName) || row == null) {
            LOG.error("table name or rows can not be empty");
            return false;
        }
        List<HbaseRow> rows = new ArrayList<>(1);
        rows.add(row);
        return put(tableName, rows);
    }


}
