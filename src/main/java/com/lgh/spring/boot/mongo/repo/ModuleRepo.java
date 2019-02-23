package com.lgh.spring.boot.mongo.repo;

import com.lgh.spring.boot.mongo.model.module.MModule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ModuleRepo extends MongoRepository<MModule, String> {

    Page<MModule> findByNameContaining(String name, Pageable pageable);
}
