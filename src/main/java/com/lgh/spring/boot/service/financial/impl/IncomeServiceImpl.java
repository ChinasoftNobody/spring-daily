package com.lgh.spring.boot.service.financial.impl;

import com.lgh.spring.boot.mapper.finance.IncomeMapper;
import com.lgh.spring.boot.model.finance.MIncomeCard;
import com.lgh.spring.boot.service.financial.IncomeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {
    @Resource
    private IncomeMapper incomeMapper;

    @Override
    public boolean createCard(MIncomeCard card) {

        return incomeMapper.createCard(card);
    }

    @Override
    public List<MIncomeCard> queryCards(String keyword) {
        return incomeMapper.queryCards(keyword);
    }
}
