package com.lgh.spring.boot.service.financial.impl;

import com.lgh.spring.boot.mapper.finance.ExpendMapper;
import com.lgh.spring.boot.model.finance.MExpendCard;
import com.lgh.spring.boot.service.financial.ExpendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExpendServiceImpl implements ExpendService {
    @Resource
    private ExpendMapper expendMapper;

    @Override
    public boolean createCard(MExpendCard card) {

        return expendMapper.createCard(card);
    }

    @Override
    public List<MExpendCard> queryCards(String keyword) {
        return expendMapper.queryCards(keyword);
    }
}
