package com.lgh.spring.boot.repo.schedule;

import com.lgh.spring.boot.model.MSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/4/3.
 * 日程表服务
 */
public interface ScheduleRepo extends JpaRepository<MSchedule,String> {

}
