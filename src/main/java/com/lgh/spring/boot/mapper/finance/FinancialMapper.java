package com.lgh.spring.boot.mapper.finance;

import com.lgh.spring.boot.model.MRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinancialMapper {

    List<MRecord> queryAll();

    boolean insert(@Param("record") MRecord record);
}
