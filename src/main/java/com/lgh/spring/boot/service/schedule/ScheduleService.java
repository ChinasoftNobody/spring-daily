package com.lgh.spring.boot.service.schedule;

import com.lgh.spring.boot.model.MEvent;

import java.util.List;

/**
 * Created by Administrator on 2017/4/3.
 * 日程服务
 */
public interface ScheduleService {
    List<MEvent> findByUserName(String userName);

    boolean addEvent(MEvent event);
}
