package com.lgh.spring.boot.mongo.repo;

import com.lgh.spring.boot.mongo.model.library.MResource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepo extends MongoRepository<MResource, Integer> {
}
