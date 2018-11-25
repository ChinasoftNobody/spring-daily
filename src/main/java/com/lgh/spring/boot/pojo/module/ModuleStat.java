package com.lgh.spring.boot.pojo.module;

import com.lgh.spring.boot.model.MModule;

import java.util.List;

/**
 * 统计module信息
 */
public class ModuleStat {
    private MModule module;
    private List<FeatureStat> featureStats;

    public MModule getModule() {
        return module;
    }

    public void setModule(MModule module) {
        this.module = module;
    }

    public List<FeatureStat> getFeatureStats() {
        return featureStats;
    }

    public void setFeatureStats(List<FeatureStat> featureStats) {
        this.featureStats = featureStats;
    }
}
