package com.lgh.spring.boot.service.schedule;

import com.lgh.spring.boot.model.MEvent;
import org.springframework.data.domain.Page;

/**
 * Created by Administrator on 2017/4/3.
 * 日程服务
 */
public interface ScheduleService {
    Page<MEvent> findByUserName(String userName, int pageNumber, int pageSize);

    boolean addEvent(MEvent event);
}
