package com.lgh.spring.boot.service.dashboard;

import com.lgh.spring.boot.common.Response;

/**
 * Created by Administrator on 2017/5/12.
 *
 */
public interface DashboardService {
    Response trendStatistics(String userName);
}
