package com.lgh.spring.boot.service.feature.impl;

import com.lgh.spring.boot.mapper.FeatureMapper;
import com.lgh.spring.boot.mapper.RecordMapper;
import com.lgh.spring.boot.mapper.UserMapper;
import com.lgh.spring.boot.model.MFeature;
import com.lgh.spring.boot.model.MRecord;
import com.lgh.spring.boot.model.MTemplate;
import com.lgh.spring.boot.pojo.feature.Record;
import com.lgh.spring.boot.service.feature.FeatureService;
import com.lgh.spring.boot.service.template.TemplateService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class FeatureServiceImpl implements FeatureService {
    private static final Log LOG = LogFactory.getLog(FeatureServiceImpl.class);

    @Resource
    private FeatureMapper featureMapper;

    @Resource
    private RecordMapper recordMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private TemplateService templateService;

    @Override
    public List<MFeature> queryByModuleId(int moduleId) {
        return featureMapper.queryByModuleId(moduleId);
    }

    @Override
    public MFeature queryById(int featureId) {
        return featureMapper.queryById(featureId);
    }

    @Override
    public List<MRecord> records(int featureId) {
        List<MTemplate> templates = templateService.queryByFeatureId(featureId);
        if (templates == null || templates.isEmpty()) {
            return Collections.emptyList();
        }
        MTemplate template = templates.get(0);
        return recordMapper.queryByTemplateId(template.getId());
    }

    @Override
    public boolean deleteRecord(int recordId) {
        return recordMapper.deleteById(recordId);
    }

    @Override
    public void createRecord(int featureId, Record record) {

    }
}
