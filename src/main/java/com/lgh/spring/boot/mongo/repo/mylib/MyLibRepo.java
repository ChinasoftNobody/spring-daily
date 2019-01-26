package com.lgh.spring.boot.mongo.repo.mylib;

import com.lgh.spring.boot.mongo.model.mylib.MDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyLibRepo extends MongoRepository<MDoc, Integer> {

    /**
     * find by subject
     * @param subject subject
     * @return doc
     */
    MDoc findFirstBySubject(String subject);
}
