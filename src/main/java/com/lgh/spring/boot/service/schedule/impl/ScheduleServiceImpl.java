package com.lgh.spring.boot.service.schedule.impl;

import com.lgh.spring.boot.model.MEvent;
import com.lgh.spring.boot.repo.EventRepo;
import com.lgh.spring.boot.service.schedule.ScheduleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/4/3.
 * 日程服务实现
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Resource
    private EventRepo eventRepo;

    @Override
    public Page<MEvent> findByUserName(String userName, int pageNumber, int pageSize) {
        pageNumber = pageNumber < 0 ? 1 : pageNumber;
        pageSize = pageSize < 0 ? 10 : pageSize;
        return eventRepo.findByUserName(userName, new PageRequest(pageNumber, pageSize));
    }

    @Override
    public boolean addEvent(MEvent event) {
        MEvent event1 = eventRepo.save(event);
        return event1 != null;
    }
}
