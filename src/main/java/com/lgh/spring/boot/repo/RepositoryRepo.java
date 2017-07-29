package com.lgh.spring.boot.repo;

import com.lgh.spring.boot.model.MRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/7/29.
 */
public interface RepositoryRepo extends JpaRepository<MRepository,String> {

    Page<MRepository> findByNameContaining(Pageable pageable, String keywords);
}
