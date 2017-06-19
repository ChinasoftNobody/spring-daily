package com.lgh.spring.boot.repo;

import com.lgh.spring.boot.model.MModule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/6/19.
 *
 */
public interface ModuleRepo extends JpaRepository<MModule,String> {
}
