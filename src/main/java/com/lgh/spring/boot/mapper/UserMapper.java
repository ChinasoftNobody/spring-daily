package com.lgh.spring.boot.mapper;

import com.lgh.spring.boot.model.MUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    MUser first();

    MUser selectByNameAndPassword(@Param("name") String name,@Param("password") String password);

    MUser selectByName(@Param("name") String name);

    boolean insert(@Param("user") MUser user);

    MUser selectById(@Param("id") int id);

    List<MUser> selectAll();
}
