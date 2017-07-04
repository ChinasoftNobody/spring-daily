package com.lgh.spring.boot.service.schedule;

import com.lgh.spring.boot.model.MEvent;
import com.lgh.spring.boot.pojo.schedule.WeekScheduleResponse;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Administrator on 2017/4/3.
 * 日程服务
 */
public interface ScheduleService {

    /**
     * 根据用户名查询事件信息
     * @param userName 用户名称
     * @param pageNumber 页数
     * @param pageSize 每页大小
     * @return 结果信息
     */
    Page<MEvent> findByUserName(String userName, int pageNumber, int pageSize);

    /**
     * 添加事件
     * @param event 事件信息
     * @return 结果信息
     */
    boolean addEvent(MEvent event);

    /**
     * 获取当前用户的本周日程
     * @param userName 当前用户
     * @return 日程信息
     */
    List<WeekScheduleResponse> weekSchedule(String userName);
}
