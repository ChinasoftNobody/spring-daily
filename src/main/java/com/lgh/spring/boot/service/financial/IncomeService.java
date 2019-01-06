package com.lgh.spring.boot.service.financial;

import com.lgh.spring.boot.model.finance.MIncomeCard;

import java.util.List;

public interface IncomeService {

    boolean createCard(MIncomeCard card);

    List<MIncomeCard> queryCards(String keyword);
}
