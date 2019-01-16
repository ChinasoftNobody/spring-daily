package com.lgh.spring.boot.mapper;

import com.lgh.spring.boot.model.library.MResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceMapper {
    void dropAll();

    void save(@Param("resources") List<MResource> resources);
}
