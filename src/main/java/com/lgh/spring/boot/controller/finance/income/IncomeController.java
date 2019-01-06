package com.lgh.spring.boot.controller.finance.income;

import com.lgh.spring.boot.annotation.Fragment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/finance/income")
public class IncomeController {
    @PostMapping("/cards")
    @Fragment
    public String cards(Model model, String keyword){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        if (StringUtils.isEmpty(keyword)){
            arrayList.add("");
            arrayList.add("");
        }
        model.addAttribute("cards",arrayList);
        return "/finance/income/cards::finance-income-cards";
    }
}
