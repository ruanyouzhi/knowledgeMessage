package com.km.knowledgemessage.controller;

import com.km.knowledgemessage.Model.Card;
import com.km.knowledgemessage.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CardAddController {
    @Autowired
    private CardService cardService;
    @CrossOrigin
    @PostMapping(value = "api/addcard")
    @ResponseBody
    public Map<String,Long> addcard(@RequestBody Card card){

        Map<String,Long>map=new HashMap<>();

        try {
            Long cardId=cardService.addCard(card);
            map.put("cardId",cardId);
            map.put("status", (long) 1);
        }catch (Exception e){
            map.put("status", (long) 0);
        }
        return map;
    }
}
