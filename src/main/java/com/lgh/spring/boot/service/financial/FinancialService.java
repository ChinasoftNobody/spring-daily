package com.lgh.spring.boot.service.financial;

import com.github.pagehelper.Page;
import com.lgh.spring.boot.model.MRecord;

public interface FinancialService {

    /**
     * 分页查询所有收支记录
     * @return page
     */
    Page<MRecord> queryAll();

}
