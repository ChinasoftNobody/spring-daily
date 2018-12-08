package com.lgh.spring.boot.mapper;

import com.lgh.spring.boot.model.MRecord;

import java.util.List;

public interface FinancialMapper {

    List<MRecord> queryAll();
}
