package com.lgh.spring.boot.mongo.repo;

import com.lgh.spring.boot.pojo.plugin.PluginMeta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PluginMetaRepo extends MongoRepository<PluginMeta, String> {
}
