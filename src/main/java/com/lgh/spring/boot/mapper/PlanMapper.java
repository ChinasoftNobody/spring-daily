package com.lgh.spring.boot.mapper;

import com.lgh.spring.boot.model.MPlan;
import com.lgh.spring.boot.model.MPlanFragment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlanMapper {
    void createPlan(@Param("plan") MPlan plan);
    void createFragments(@Param("fragments")List<MPlanFragment> fragments);

    List<MPlan> queryAllPlans();
}
