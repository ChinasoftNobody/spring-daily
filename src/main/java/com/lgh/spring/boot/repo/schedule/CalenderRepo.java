package com.lgh.spring.boot.repo.schedule;

import com.lgh.spring.boot.model.MCalender;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/4/3.
 */
public interface CalenderRepo extends JpaRepository<MCalender,String> {
}
