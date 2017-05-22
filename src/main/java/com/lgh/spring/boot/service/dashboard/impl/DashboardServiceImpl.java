package com.lgh.spring.boot.service.dashboard.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lgh.spring.boot.common.Response;
import com.lgh.spring.boot.model.MEvent;
import com.lgh.spring.boot.repo.EventRepo;
import com.lgh.spring.boot.service.dashboard.DashboardService;
import com.lgh.spring.boot.util.ResponseUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 *
 */
@Service
public class DashboardServiceImpl implements DashboardService {

    @Resource
    private EventRepo eventRepo;


    @Override
    public Response trendStatistics(String userName) {
        if(StringUtils.isEmpty(userName)){
            return ResponseUtil.failed("userName not found!");
        }
        JSONObject result = statistics(null);
        return ResponseUtil.ok(result);
    }

    private JSONObject statistics(List<MEvent> mEventList) {
        JSONObject result = new JSONObject();
        result.put("indicator", JSONArray.parseArray("[{ name: '学习', max: 40}," +
                "{ name: '家庭', max: 12},{ name: '工作', max: 11},{ name: '休闲', max: 30}," +
                "{ name: '思考', max: 20},{ name: '娱乐', max: 16}]"));
        result.put("data", JSON.parseArray("[{value : [1, 3, 4, 6, 1, 2],name : '日常偏向'}]"));
        if(mEventList == null || mEventList.isEmpty()){
            return result;
        }
        return result;
    }
}
