package com.lgh.spring.boot.mongo.repo;

import com.lgh.spring.boot.mongo.model.MUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<MUser, Integer> {
}
