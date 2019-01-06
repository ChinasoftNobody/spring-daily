package com.lgh.spring.boot.controller.finance.expend;

import com.lgh.spring.boot.annotation.Fragment;
import com.lgh.spring.boot.model.finance.MExpendCard;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.service.financial.ExpendService;
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
@RequestMapping("/finance/expend")
public class ExpendController {
    @Resource
    private ExpendService expendService;

    @PostMapping("/cards")
    @Fragment
    public String cards(Model model, String keyword){
        List<MExpendCard> arrayList = expendService.queryCards(keyword);
        model.addAttribute("cards",arrayList);
        return "/finance/expend/cards::finance-expend-cards";
    }

    @PostMapping("/createCard")
    @ResponseBody
    public Response createCard(@RequestBody MExpendCard card){
        if (expendService.createCard(card)){
            return ResponseUtil.success(card);
        }
        return ResponseUtil.error("failed");
    }
}
