package com.lgh.spring.boot.service.financial;

import com.lgh.spring.boot.model.finance.MExpendCard;

import java.util.List;

public interface ExpendService {

    boolean createCard(MExpendCard card);

    List<MExpendCard> queryCards(String keyword);
}
