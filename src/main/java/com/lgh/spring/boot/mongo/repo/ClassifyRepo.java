package com.lgh.spring.boot.mongo.repo;

import com.lgh.spring.boot.mongo.model.library.MClassify;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassifyRepo extends MongoRepository<MClassify, Integer> {
}
