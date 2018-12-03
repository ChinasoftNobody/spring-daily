package com.lgh.spring.boot.mapper;

import com.lgh.spring.boot.model.MTemplateProperty;
import org.apache.ibatis.annotations.Param;

public interface TemplatePropertyMapper {

    boolean create(@Param("property") MTemplateProperty property);

    boolean deleteById(@Param("propertyId") int propertyId);
}
