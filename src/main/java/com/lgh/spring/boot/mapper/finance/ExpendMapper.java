package com.lgh.spring.boot.mapper.finance;

import com.lgh.spring.boot.model.finance.MExpendCard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExpendMapper {

    boolean createCard(@Param("card") MExpendCard card);

    List<MExpendCard> queryCards(@Param("keyword") String keyword);
}
