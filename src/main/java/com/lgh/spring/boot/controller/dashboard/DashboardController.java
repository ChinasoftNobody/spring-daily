package com.lgh.spring.boot.controller.dashboard;

import com.lgh.spring.boot.common.Response;
import com.lgh.spring.boot.pojo.dashboard.TrendStatisticsRequest;
import com.lgh.spring.boot.service.dashboard.DashboardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/5/12.
 * Dashboard
 */
@Api(tags = "Dashboard")
@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    @Resource
    private DashboardService dashboardService;

    @PostMapping(value = "/trendStatistics",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "trend statistics in dashboard",notes = "trend statistics in dashboard")
    public Response trendStatistics(@RequestBody TrendStatisticsRequest request){
        return dashboardService.trendStatistics(request.getUserName());
    }
}
