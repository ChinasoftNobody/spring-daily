package com.lgh.spring.boot.service.schedule.impl;

import com.lgh.spring.boot.model.MEvent;
import com.lgh.spring.boot.repo.EventRepo;
import com.lgh.spring.boot.service.schedule.ScheduleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/3.
 * 日程服务实现
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Resource
    private EventRepo eventRepo;

    @Override
    public List<MEvent> findByUserName(String userName) {
        return eventRepo.findByUserName(userName);
    }

    @Override
    public boolean addEvent(MEvent event) {
        MEvent event1 = eventRepo.save(event);
        return event1 != null;
    }
}
