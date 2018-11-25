package com.lgh.spring.boot.mapper;

import com.lgh.spring.boot.model.MFeature;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeatureMapper {

    /**
     * 根据moduleID查询feature信息
     * @param moduleId moduleId
     * @return result
     */
    List<MFeature> queryByModuleId(@Param("moduleId") int moduleId);

    /**
     * 根据ID查询
     * @param featureId featureId
     * @return result
     */
    MFeature queryById(@Param("featureId") int featureId);
}
