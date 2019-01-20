package com.lgh.spring.boot.service.library;


import com.lgh.spring.boot.mongo.model.library.MResource;

import java.util.List;

/**
 * 图书资源服务
 */
public interface ResourceService {
    /**
     * 获取图书馆统一检索资源信息
     * @return result
     */
    List<MResource> queryExternalResource();

    void dropAll();

    void save(List<MResource> resources);
}
