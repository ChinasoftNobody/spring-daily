package com.lgh.spring.boot.service.financial;

import com.github.pagehelper.Page;
import com.lgh.spring.boot.model.MRecord;
import com.lgh.spring.boot.pojo.finance.RecordQuery;

public interface FinancialService {

    /**
     * 分页查询所有收支记录
     * @return page
     */
    Page<MRecord> queryAll();

    void addRecord(MRecord record);

    Page<MRecord> queryByFilter(RecordQuery query);
}
