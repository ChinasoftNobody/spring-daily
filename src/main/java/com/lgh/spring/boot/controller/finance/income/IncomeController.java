package com.lgh.spring.boot.controller.finance.income;

import com.lgh.spring.boot.annotation.Fragment;
import com.lgh.spring.boot.model.finance.MIncomeCard;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.service.financial.IncomeService;
import com.lgh.spring.boot.util.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/finance/income")
public class IncomeController {
    @Resource
    private IncomeService incomeService;

    @PostMapping("/cards")
    @Fragment
    public String cards(Model model, String keyword){
        List<MIncomeCard> arrayList = incomeService.queryCards(keyword);
        model.addAttribute("cards",arrayList);
        return "/finance/income/cards::finance-income-cards";
    }

    @PostMapping("/createCard")
    @ResponseBody
    public Response createCard(@RequestBody MIncomeCard card){
        if (incomeService.createCard(card)){
            return ResponseUtil.success(card);
        }
        return ResponseUtil.error("failed");
    }
}
