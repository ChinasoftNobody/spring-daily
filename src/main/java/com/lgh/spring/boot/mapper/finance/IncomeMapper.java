package com.lgh.spring.boot.mapper.finance;

import com.lgh.spring.boot.model.finance.MIncomeCard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IncomeMapper {

    boolean createCard(@Param("card") MIncomeCard card);

    List<MIncomeCard> queryCards(@Param("keyword") String keyword);
}
