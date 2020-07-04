package com.km.knowledgemessage.controller;

import com.km.knowledgemessage.Model.User;
import com.km.knowledgemessage.service.KumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class wordCloudController {
    @Resource
    public KumoService kumoService;
    @RequestMapping("api/wordCloud")
    @CrossOrigin
    @ResponseBody
    public Map<String,Object> wordCloud(@RequestParam long cardId) {
        Map<String, Object> map = new HashMap<>();
        String wordCloud = kumoService.getWordCloud(cardId);
        try {
            map.put("wordCloud",wordCloud);
            map.put("status", (long) 1);
        } catch (Exception e) {
            map.put("status", (long) 0);
        }
        return map;
    }
}
