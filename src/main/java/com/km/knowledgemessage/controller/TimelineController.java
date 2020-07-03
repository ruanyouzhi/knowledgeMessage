package com.km.knowledgemessage.controller;
import com.km.knowledgemessage.dto.TimeLineDTO;
import com.km.knowledgemessage.service.KnowledgeBaseService;
import com.km.knowledgemessage.utils.SetCardNumService;
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
    @Autowired
    public SetCardNumService setCardNumService;
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
    @CrossOrigin
    @RequestMapping("api/upLikeNum")
    @ResponseBody
    public Map<String,Object> upLikeNum(@RequestParam Long userId,
                                        @RequestParam Long cardId){
        Map<String,Object>map=new HashMap<>();
        try {
            Long aLong = setCardNumService.upLikeNum(userId, cardId);
            map.put("likeNum",aLong);
            map.put("status", (long) 1);
        }catch (Exception e){
            map.put("status", (long) 0);
        }
        return map;
    }
    @CrossOrigin
    @RequestMapping("api/upCollect")
    @ResponseBody
    public Map<String,Object> upCollect(@RequestParam Long userId,
                                        @RequestParam Long cardId){
        Map<String,Object>map=new HashMap<>();
        Long aLong = setCardNumService.upCollect(userId, cardId);
        try {

            map.put("collectNum",aLong);
            map.put("status", (long) 1);
        }catch (Exception e){
            map.put("status", (long) 0);
        }
        return map;
    }
}
