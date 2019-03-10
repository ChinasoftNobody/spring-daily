package com.lgh.spring.boot.service.record;

import com.lgh.spring.boot.exception.ServerException;
import com.lgh.spring.boot.mongo.model.record.MRecord;

import java.util.List;

public interface RecordService {

    List<MRecord> findByModuleId(String id);

    MRecord update(MRecord record)throws ServerException;
}
