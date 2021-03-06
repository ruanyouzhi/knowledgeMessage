package com.km.knowledgemessage.controller;
import com.km.knowledgemessage.Model.Card;
import com.km.knowledgemessage.service.AddCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CardAddController {
    @Autowired
    private AddCardService addCardService;

    @CrossOrigin
    @PostMapping(value = "api/addcard")
    @ResponseBody
    public Map<String,Long> addcard(@RequestBody Card card){

        Map<String,Long>map=new HashMap<>();

        try {
            Long cardId=addCardService.addCard(card);
            map.put("cardId",cardId);
            map.put("status", (long) 1);
        }catch (Exception e){
            map.put("status", (long) 0);
        }
        return map;
    }
    @CrossOrigin
    @PostMapping(value = "api/modifiedcard")
    @ResponseBody
    public Map<String,Object> modified(@RequestParam(name = "userId")long userId,
                                     @RequestParam(name = "cardId")long cardId) {

        Map<String, Object> map = new HashMap<>();

        try {
            Card card = addCardService.getCard(cardId);
            if (userId != card.getCreatorId()) {
                map.put("error", "不是卡片创建者");
            } else {

                map.put("status", (long) 1);
            }

        } catch (Exception e) {
            map.put("status", (long) 0);
        }
        return map;
    }
    @CrossOrigin
    @RequestMapping(value = "api/getCard")
    @ResponseBody
    public Map<String,Object> getCard(@RequestParam long cardId){

        Map<String,Object>map=new HashMap<>();

        try {
            Card card=addCardService.getCard(cardId);
            map.put("card",card);
            map.put("status", (long) 1);
        }catch (Exception e){
            map.put("status", (long) 0);
        }
        return map;
    }
    @CrossOrigin
    @RequestMapping(value = "api/upCard")
    @ResponseBody
    public Map<String,Object> upCard(@RequestBody Card card){

        Map<String,Object>map=new HashMap<>();

        try {
            addCardService.upCard(card);
            map.put("status", (long) 1);
        }catch (Exception e){
            map.put("status", (long) 0);
        }
        return map;
    }
}
