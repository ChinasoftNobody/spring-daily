package com.lgh.spring.boot.service.financial.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lgh.spring.boot.mapper.finance.FinancialMapper;
import com.lgh.spring.boot.model.MRecord;
import com.lgh.spring.boot.pojo.finance.RecordQuery;
import com.lgh.spring.boot.service.financial.FinancialService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FinancialServiceImpl implements FinancialService {
    @Resource
    private FinancialMapper financialMapper;

    @Override
    public Page<MRecord> queryAll() {
        Page<MRecord> page = PageHelper.startPage(1, 10, true);
        List<MRecord> records = financialMapper.queryAll();
        return page;
    }

    @Override
    public void addRecord(MRecord record) {
        financialMapper.insert(record);
    }

    @Override
    public Page<MRecord> queryByFilter(RecordQuery query) {
        Page<MRecord> page = PageHelper.startPage(query.getPage(),query.getSize(),true);
        List<MRecord> records = financialMapper.queryAll();
        return page;
    }
}
