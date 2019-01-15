package com.lgh.spring.boot.mapper;

import com.lgh.spring.boot.model.library.MClassify;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassifyMapper {
    /**
     * 清空表信息
     */
    void dropAll();

    /**
     * 批量保存
     * @param classifies classifies
     */
    void save(@Param("classifies") List<MClassify> classifies);
}
