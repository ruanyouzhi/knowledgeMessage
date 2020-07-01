package com.km.knowledgemessage.controller;

import com.km.knowledgemessage.Model.Card;
import com.km.knowledgemessage.Model.CardNum;
import com.km.knowledgemessage.Model.KnowledgeBase;
import com.km.knowledgemessage.Model.User;
import com.km.knowledgemessage.service.CardReviewService;
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
public class CardReviewController {
    // 卡片复习控制类
    @Autowired
    private CardReviewService cardReviewService;
    @Autowired
    private ShowCardService showCardService;

    @CrossOrigin
    @RequestMapping(value = "api/review")
    @ResponseBody
    public Map<String,Object> checkknowledge(@RequestParam Long userId){
        // 检查知识会不会
        HashMap<String, Object> map=new HashMap<>();
        try {
//
            User user = cardReviewService.getUser(userId);
            List<KnowledgeBase> knowledgeBases = cardReviewService.getReviewCards(user);
            map.put("reviewKnowledgeBases", knowledgeBases);
            map.put("status", "true");
        }catch (Exception e){
            map.put("status", "false");
        }
        return map;
    }
    @CrossOrigin
    @RequestMapping(value = "api/showknowledgebase")
    @ResponseBody
    public Map<String,Object> reviewResult(@RequestParam Long knowledgeBaseId, int state){

        HashMap<String, Object> map=new HashMap<>();
        try {
            Card card = cardReviewService.getReviewResult(knowledgeBaseId, state);
            if(card != null){
                long cardId = card.getId();

                CardNum cardNum = showCardService.getCardNum(cardId);
                String title = card.getTitle();
                String creatorname = showCardService.showCardCreator(cardId, card.getCreatorId());
                String cardContent= card.getCardText();
                String cardDescription = card.getCardDescription();
                String cardLable = showCardService.showCardLable(cardId, card.getCreatorId());
                map.put("cardTitle", title);
                map.put("creatorName", creatorname);
                map.put("cardDescription", cardDescription);
                map.put("cardLable", cardLable);
                map.put("cardContent", cardContent);
                map.put("modifiedTime", card.getGmtModified());
                map.put("likeNumber", cardNum.getLikeNum());
                map.put("commentNumber", cardNum.getCommentNum());
                map.put("collectNumber", cardNum.getCollectNum());
            }

            map.put("status", "true");
        }catch (Exception e){
            map.put("status", "false");
        }
        return map;
    }

    /*
    上次复习时间：33

    卡片创建时间：1593529811951

    id：33

    上次复习时间：1593529811951

    复习次数：0

    上次修改时间：1593529811951

    卡片编号：32
    */
}

