package com.km.knowledgemessage.controller;

import com.km.knowledgemessage.service.AddCardService;
import com.km.knowledgemessage.service.ShowCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
// by wfanyue
@Controller
public class CardShowController {

    @Autowired
    private ShowCardService showCardService;
    @CrossOrigin
    @RequestMapping(value = "api/showcard")
    @ResponseBody
    public Map<String,String> showcard(@RequestParam Long cardId, Long userId){
// 添加创建者，标题，标签， 添加收藏，点赞（只能一次，多次就取消），评论最后
        HashMap<String, String> map=new HashMap<>();
        try {

            String cardContent= showCardService.showCard(cardId, userId);
            String cardSrc = showCardService.showCardScr(cardId, userId);
            map.put("cardContent", cardContent);
            map.put("cardSrc", cardSrc);
            map.put("status", "true");
        }catch (Exception e){
            map.put("status", "false");
        }
        return map;
    }
}
