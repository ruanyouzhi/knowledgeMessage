package com.km.knowledgemessage.controller;

import com.km.knowledgemessage.Model.Card;
import com.km.knowledgemessage.Model.CardNum;
import com.km.knowledgemessage.Model.KnowledgeBase;
import com.km.knowledgemessage.Model.User;
import com.km.knowledgemessage.service.CardReviewService;
import com.km.knowledgemessage.service.CardSearchService;
import com.km.knowledgemessage.service.ShowCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
// by wfanyue
@Controller
public class CardSearchController {
    // 卡片搜索
    @Autowired
    private CardSearchService cardSearchService;
    @Autowired
    private ShowCardService showCardService;

    @CrossOrigin
    @RequestMapping(value = "api/search")
    @ResponseBody
    public Map<String,Object> searchContext(@RequestParam String context){
        // 检查知识会不会
        HashMap<String, Object> map=new HashMap<>();
        try {
//
            List<Card> cards = cardSearchService.getSearchCard(context);
            map.put("searchCards", cards);
            map.put("status", "true");
        }catch (Exception e){
            map.put("status", "false");
        }
        return map;
    }

}

