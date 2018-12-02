package com.lgh.spring.boot.mapper;

import com.lgh.spring.boot.model.MTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemplateMapper {

    List<MTemplate> queryByFeatureId(@Param("featureId") int featureId);

    boolean create(@Param("template") MTemplate template);

    void deleteById(@Param("templateId") int templateId);
}
