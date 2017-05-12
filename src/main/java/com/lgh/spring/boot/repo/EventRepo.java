package com.lgh.spring.boot.repo;

import com.lgh.spring.boot.model.MEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 *
 */
public interface EventRepo extends JpaRepository<MEvent,String> {


    List<MEvent> findByUserName(@Param("userName") String userName);
}
