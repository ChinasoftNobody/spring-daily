package com.lgh.spring.boot.service.schedule;

import com.alibaba.fastjson.JSONArray;
import com.lgh.spring.boot.common.Response;
import com.lgh.spring.boot.pojo.schedule.EstablishScheduleRequest;

/**
 * Created by Administrator on 2017/4/3.
 * 日程服务
 */
public interface ScheduleService {

    Response establishSchedule(EstablishScheduleRequest request);

    JSONArray findAll();
}
