package com.km.knowledgemessage.controller;

import com.km.knowledgemessage.Model.Card;
import com.km.knowledgemessage.Model.CardNum;
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
// 依次显示卡片标题， 创建者， 卡片描述， 标签， 卡片内容, 。
            Card card = showCardService.getCard(cardId);
            CardNum cardNum = showCardService.getCardNum(cardId);
            String title = card.getTitle();
            String creatorname = showCardService.showCardCreator(cardId, userId);
            String cardContent= card.getCardText();
            String cardDescription = card.getCardDescription();
            String cardLable = showCardService.showCardLable(cardId, userId);
            map.put("cardTitle", title);
            map.put("creatorName", creatorname);
            map.put("cardDescription", cardDescription);
            map.put("labelName", cardLable);
            map.put("cardText", cardContent);
            map.put("gmtModified", card.getGmtModified().toString());
            map.put("likeNum", cardNum.getLikeNum().toString());
            map.put("commentNum", cardNum.getCommentNum().toString());
            map.put("collectNum", cardNum.getCollectNum().toString());
            map.put("status", "true");
        }catch (Exception e){
            map.put("status", "false");
        }
        return map;
    }
}
