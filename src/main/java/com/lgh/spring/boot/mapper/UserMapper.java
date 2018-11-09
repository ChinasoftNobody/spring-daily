package com.lgh.spring.boot.mapper;

import com.lgh.spring.boot.model.MUser;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from t_user limit 1")
    MUser first();
}
