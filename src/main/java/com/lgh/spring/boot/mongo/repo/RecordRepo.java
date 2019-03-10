package com.lgh.spring.boot.mongo.repo;

import com.lgh.spring.boot.mongo.model.module.MModule;
import com.lgh.spring.boot.mongo.model.plugin.MPlugin;
import com.lgh.spring.boot.mongo.model.record.MRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepo extends MongoRepository<MRecord, String> {

    List<MRecord> findByModuleAndPlugin(MModule module, MPlugin plugin);
}
