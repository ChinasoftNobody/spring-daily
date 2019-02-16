package com.lgh.spring.boot.mongo.repo;

import com.lgh.spring.boot.mongo.model.library.MBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends MongoRepository<MBook, String> {

    Page<MBook> findAllByNameContains(String keyword, Pageable pageable);
}
