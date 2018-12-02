package com.lgh.spring.boot.mapper;

import com.lgh.spring.boot.model.MRecord;
import com.lgh.spring.boot.pojo.feature.Record;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordMapper {
    /**
     * 根据featureId查询记录
     * @param featureId featureId
     * @return result
     */
    List<Record> queryByFeatureId(@Param("featureId") int featureId);

    /**
     * 创建记录
     * @param mRecord 记录信息
     * @return 结果
     */
    boolean create(@Param("record") MRecord mRecord);

    boolean deleteById(@Param("recordId") int recordId);
}
