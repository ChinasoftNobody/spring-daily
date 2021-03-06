package com.lgh.spring.boot.mongo.repo;

import com.lgh.spring.boot.mongo.model.plugin.MPlugin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PluginRepo extends MongoRepository<MPlugin, String> {

    Page<MPlugin> findByNameContainingOrDescContaining(String keyword, Pageable pageable);
}
