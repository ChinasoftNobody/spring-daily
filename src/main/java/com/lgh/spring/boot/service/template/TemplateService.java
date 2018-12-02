package com.lgh.spring.boot.service.template;

import com.lgh.spring.boot.model.MTemplate;

import java.util.List;

public interface TemplateService {
    List<MTemplate> queryByFeatureId(int featureId);

    void create(MTemplate template);

    void deleteById(int templateId);

    MTemplate queryById(int templateId);
}
