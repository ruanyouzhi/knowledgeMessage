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
    public Map<String,Boolean> addcard(@RequestBody Card card){

        Map<String,Boolean>map=new HashMap<>();
        try {
            cardService.addCard(card);
            map.put("status",true);
        }catch (Exception e){
            map.put("status",false);
        }
        return map;
    }
}
