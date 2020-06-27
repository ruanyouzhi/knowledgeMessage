package com.km.knowledgemessage.controller;

import com.km.knowledgemessage.dto.PaginationDTO;
import com.km.knowledgemessage.service.KnowledgeBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CardBaseController {
    @Autowired
    private KnowledgeBaseService knowledgeBaseService;
    @CrossOrigin
    @RequestMapping(value = "api/getcardlist")
    @ResponseBody
    public Map<String,Object> getcardlist(@RequestParam(name = "userId", defaultValue = "1")Integer userId,
                                        @RequestParam(name = "page", defaultValue = "1")Integer page,
                                        @RequestParam(name = "size", defaultValue = "5" ) Integer size,
                                        @RequestParam(name = "search", required = false) String search){

        Map<String,Object>map=new HashMap<>();

        try {

            PaginationDTO pageList = knowledgeBaseService.list(userId, search, page, size);
            map.put("paginationList", pageList);
            map.put("status", (long) 1);
        }catch (Exception e){
            map.put("status", (long) 0);
        }
        return map;
    }
    @CrossOrigin
    @RequestMapping("api/delcard")
    @ResponseBody
    public Map<String,Long> delCard(@RequestParam(name = "userId")long userId,
                                    @RequestParam(name = "cardId")long cardId,
                                    @RequestParam(name = "creatorId")long creatorId){

        Map<String,Long>map=new HashMap<>();

        try {
            knowledgeBaseService.delCard(userId,cardId,creatorId);
            map.put("status", (long) 1);
        }catch (Exception e){
            map.put("status", (long) 0);
        }
        return map;
    }

}
