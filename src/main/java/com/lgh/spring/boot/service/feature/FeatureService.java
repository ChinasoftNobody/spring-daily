package com.lgh.spring.boot.service.feature;

import com.lgh.spring.boot.model.MFeature;
import com.lgh.spring.boot.model.MRecord;
import com.lgh.spring.boot.pojo.feature.Record;

import java.util.List;

public interface FeatureService {
    /**
     * 根据moduleId查询feature信息
     * @param moduleId moduleId
     * @return feature 信息
     */
    List<MFeature> queryByModuleId(int moduleId);

    /**
     * 根据ID查询
     * @param featureId featureId
     * @return result
     */
    MFeature queryById(int featureId);

    /**
     * 根据featureID查询记录
     * @param featureId featureId
     * @return result
     */
    List<MRecord> records(int featureId);

    /**
     * 创建记录
     * @param featureId featureId
     * @param record record
     */
    void createRecord(int featureId, Record record);

    boolean deleteRecord(int recordId);
}
