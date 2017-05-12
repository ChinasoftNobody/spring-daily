package com.lgh.spring.boot.repo;

import com.lgh.spring.boot.model.MUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/4/3.
 *
 */
public interface UserRepo extends JpaRepository<MUser,String> {

}
