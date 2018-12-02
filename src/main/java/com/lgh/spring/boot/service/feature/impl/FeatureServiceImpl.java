package com.lgh.spring.boot.service.feature.impl;

import com.lgh.spring.boot.common.Const;
import com.lgh.spring.boot.mapper.FeatureMapper;
import com.lgh.spring.boot.mapper.RecordMapper;
import com.lgh.spring.boot.mapper.UserMapper;
import com.lgh.spring.boot.model.MFeature;
import com.lgh.spring.boot.model.MRecord;
import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.pojo.feature.Record;
import com.lgh.spring.boot.service.feature.FeatureService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
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

    @Override
    public List<MFeature> queryByModuleId(int moduleId) {
        return featureMapper.queryByModuleId(moduleId);
    }

    @Override
    public MFeature queryById(int featureId) {
        return featureMapper.queryById(featureId);
    }

    @Override
    public List<Record> records(int featureId) {
        return recordMapper.queryByFeatureId(featureId);
    }

    @Override
    public boolean deleteRecord(int recordId) {
        return recordMapper.deleteById(recordId);
    }

    @Override
    public void createRecord(int featureId, Record record) {
        MRecord mRecord = new MRecord();
        BeanUtils.copyProperties(record, mRecord);
        if (!StringUtils.isEmpty(record.getOwnerName())) {
            MUser user = userMapper.selectByName(record.getOwnerName());
            if (user != null) {
                mRecord.setOwnerId(user.getId());
            }
        }
        if (!StringUtils.isEmpty(record.getTypeName())) switch (record.getTypeName()) {
            case Const.RECORD_TYPE_NAME_SIMPLE:
                mRecord.setType(Const.RECORD_TYPE_ID_SIMPLE);
                break;
            case Const.RECORD_TYPE_NAME_OTHER:
                mRecord.setType(Const.RECORD_TYPE_ID_OTHER);
                break;
            default:
                mRecord.setType(Const.RECORD_TYPE_ID_SIMPLE);
                break;
        }
        if (!recordMapper.create(mRecord)) {
            LOG.error("创建记录失败");
        }
    }
}
