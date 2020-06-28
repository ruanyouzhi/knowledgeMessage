package com.km.knowledgemessage.controller;

import com.km.knowledgemessage.Model.Card;
import com.km.knowledgemessage.Model.KnowledgeBase;
import com.km.knowledgemessage.dto.PaginationDTO;
import com.km.knowledgemessage.dto.TimeLineDTO;
import com.km.knowledgemessage.service.KnowledgeBaseService;
import javafx.beans.binding.LongExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TimelineController {
    @Autowired
    public KnowledgeBaseService knowledgeBaseService;

    @CrossOrigin
    @RequestMapping("api/timeLine")
    @ResponseBody
    public Map<String,Object> timeLine(@RequestParam Long userId){
        Map<String,Object>map=new HashMap<>();
        List<TimeLineDTO> timeLineDTOList = knowledgeBaseService.simpleList(userId);
        try {
            //List<TimeLineDTO> timeLineDTOList = knowledgeBaseService.simpleList(userId);
            map.put("timeLineDTOList",timeLineDTOList);
            map.put("status", (long) 1);
        }catch (Exception e){
            map.put("status", (long) 0);
        }
        return map;
    }
}
