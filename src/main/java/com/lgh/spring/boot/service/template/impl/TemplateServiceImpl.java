package com.lgh.spring.boot.service.template.impl;

import com.lgh.spring.boot.mapper.TemplateMapper;
import com.lgh.spring.boot.model.MTemplate;
import com.lgh.spring.boot.service.template.TemplateService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {
    @Resource
    private TemplateMapper templateMapper;

    @Override
    public List<MTemplate> queryByFeatureId(int featureId) {
        return templateMapper.queryByFeatureId(featureId);
    }

    @Override
    public void create(MTemplate template) {
        if (StringUtils.isEmpty(template.getName())) {
            return;
        }
        templateMapper.create(template);
    }

    @Override
    public MTemplate queryById(int templateId) {
        MTemplate mTemplate = templateMapper.queryById(templateId);
        if (mTemplate.getProperties() == null) {
            mTemplate.setProperties(Collections.emptyList());
        }
        return mTemplate;
    }

    @Override
    public void deleteById(int templateId) {
        templateMapper.deleteById(templateId);
    }
}
