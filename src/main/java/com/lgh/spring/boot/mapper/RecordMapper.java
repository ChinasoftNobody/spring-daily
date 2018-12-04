package com.lgh.spring.boot.mapper;

import com.lgh.spring.boot.model.MRecord;
import com.lgh.spring.boot.model.MRecordProperty;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordMapper {

    /**
     * 创建记录
     * @param mRecord 记录信息
     * @return 结果
     */
    boolean create(@Param("record") MRecord mRecord);

    boolean deleteById(@Param("recordId") int recordId);

    List<MRecord> queryByTemplateId(@Param("templateId") int templateId);

    boolean createProperties(List<MRecordProperty> properties);
}
