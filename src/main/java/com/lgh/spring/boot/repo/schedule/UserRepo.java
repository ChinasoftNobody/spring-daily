package com.lgh.spring.boot.repo.schedule;

import com.lgh.spring.boot.model.MUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/4/3.
 */
public interface UserRepo extends JpaRepository<MUser,String> {

    @Query(value = "select user from MUser user join user.calenders calenders join calenders.schedules schedules")
    List<MUser> findScheduleByUserAndCalender();
}
